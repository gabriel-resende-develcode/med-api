package med.voll.api.service;

import med.voll.api.model.medico.DadosCadastroMedico;
import med.voll.api.model.medico.DadosListagemMedico;
import med.voll.api.model.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public void cadastrar(DadosCadastroMedico dadosCadastroMedico) {
        medicoRepository.save(new Medico(dadosCadastroMedico));
    }

    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
