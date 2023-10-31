package med.voll.api.service;

import med.voll.api.dto.paciente.DadosAtualizacaoPaciente;
import med.voll.api.dto.paciente.DadosCadastroPaciente;
import med.voll.api.dto.paciente.DadosListagemPaciente;
import med.voll.api.dto.paciente.PacienteResponseDTO;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
import med.voll.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente cadastrar(DadosCadastroPaciente dadosCadastroPaciente) {
        var paciente = new Paciente(dadosCadastroPaciente);
        return pacienteRepository.save(paciente);
    }

    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    public PacienteResponseDTO findById(Long id) {
        return new PacienteResponseDTO(pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no pacient with this id")));
    }

    @Transactional
    public PacienteResponseDTO atualizar(DadosAtualizacaoPaciente dadosAtualizacaoPaciente, Long id) {
        var paciente = new Paciente(findById(id));
        paciente.atualizarInformacoes(dadosAtualizacaoPaciente);
        return new PacienteResponseDTO(paciente);
    }

    @Transactional
    public void deletarById(Long id) {
        findById(id);
        pacienteRepository.deleteById(id);
    }
}
