package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.medico.MedicoResponseDTO;
import med.voll.api.dto.paciente.DadosAtualizacaoPaciente;
import med.voll.api.dto.paciente.DadosCadastroPaciente;
import med.voll.api.dto.paciente.DadosListagemPaciente;
import med.voll.api.dto.paciente.PacienteResponseDTO;
import med.voll.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente, UriComponentsBuilder uriBuilder) {
        var paciente = pacienteService.cadastrar(dadosCadastroPaciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteResponseDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginaco) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listar(paginaco));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@RequestBody DadosAtualizacaoPaciente dadosAtualizacaoPaciente, @PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.atualizar(dadosAtualizacaoPaciente, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pacienteService.deletarById(id);
        return ResponseEntity.noContent().build();
    }
}
