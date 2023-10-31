package med.voll.api.service;

import med.voll.api.dto.medico.DadosAtualizacaoMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.DadosListagemMedico;
import med.voll.api.dto.medico.MedicoResponseDTO;
import med.voll.api.model.medico.*;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    @Transactional
    public Medico cadastrar(DadosCadastroMedico dadosCadastroMedico) {
        var medico = new Medico(dadosCadastroMedico);
        return medicoRepository.save(medico);
    }

    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    public MedicoResponseDTO findById(Long id) {
        return new MedicoResponseDTO(medicoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("There is no doctor with this id")));
    }

    @Transactional
    public MedicoResponseDTO atualizar(DadosAtualizacaoMedico dadosAtualizacaoMedico, Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.atualizarInformacoes(dadosAtualizacaoMedico);
        return new MedicoResponseDTO(medico);
    }

    @Transactional
    public void deletar(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.desativarMedico();
    }
}
