package med.voll.api.service;

import med.voll.api.model.paciente.DadosCadastroPaciente;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public void cadastrar(DadosCadastroPaciente dadosCadastroPaciente){
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }
}
