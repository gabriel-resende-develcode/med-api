package med.voll.api.model.paciente;

import med.voll.api.model.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(String telefone, DadosEndereco endereco) {
}
