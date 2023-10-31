package med.voll.api.dto.paciente;

import med.voll.api.model.endereco.Endereco;
import med.voll.api.model.paciente.Paciente;

public record PacienteResponseDTO(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public PacienteResponseDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
