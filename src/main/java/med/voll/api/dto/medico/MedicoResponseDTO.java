package med.voll.api.dto.medico;

import med.voll.api.model.endereco.Endereco;
import med.voll.api.model.medico.enums.EspecialidadeMedico;
import med.voll.api.model.medico.Medico;

public record MedicoResponseDTO(Long id, String nome, String email, String crm, String telefone,
                                EspecialidadeMedico especialidade, Endereco endereco) {

    public MedicoResponseDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
