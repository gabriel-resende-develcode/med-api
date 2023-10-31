package med.voll.api.service;

import med.voll.api.model.medico.DadosAtualizacaoMedico;
import med.voll.api.model.medico.DadosCadastroMedico;
import med.voll.api.model.medico.DadosListagemMedico;
import med.voll.api.model.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    @Transactional
    public void cadastrar(DadosCadastroMedico dadosCadastroMedico) {
        medicoRepository.save(new Medico(dadosCadastroMedico));
    }

    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @Transactional
    public void atualizar(DadosAtualizacaoMedico dadosAtualizacaoMedico, Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.atualizarInformacoes(dadosAtualizacaoMedico);
    }

    @Transactional
    public void deletar(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.desativarMedico();
    }
}
