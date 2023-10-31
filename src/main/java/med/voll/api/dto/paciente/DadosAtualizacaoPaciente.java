package med.voll.api.dto.paciente;

import med.voll.api.dto.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(String telefone, DadosEndereco endereco) {
}
