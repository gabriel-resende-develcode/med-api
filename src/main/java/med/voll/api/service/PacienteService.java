package med.voll.api.service;

import med.voll.api.model.paciente.DadosAtualizacaoPaciente;
import med.voll.api.model.paciente.DadosCadastroPaciente;
import med.voll.api.model.paciente.DadosListagemPaciente;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
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
    public void cadastrar(DadosCadastroPaciente dadosCadastroPaciente) {
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }

    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @Transactional
    public void atualizar(DadosAtualizacaoPaciente dadosAtualizacaoPaciente, Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.atualizarInformacoes(dadosAtualizacaoPaciente);
    }

    @Transactional
    public void deletarById(Long id){
        pacienteRepository.deleteById(id);
    }
}
