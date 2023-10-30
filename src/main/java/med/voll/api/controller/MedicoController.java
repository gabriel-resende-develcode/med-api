package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.DadosCadastroMedico;
import med.voll.api.model.medico.DadosListagemMedico;
import med.voll.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico) {
        medicoService.cadastrar(dadosCadastroMedico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"especialidade"}) Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.listar(paginacao));
    }
}
