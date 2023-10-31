package med.voll.api.dto.medico;

import med.voll.api.model.medico.enums.EspecialidadeMedico;
import med.voll.api.model.medico.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, EspecialidadeMedico especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
