package med.voll.api.dto.medico;

import med.voll.api.dto.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(String nome, String telefone, DadosEndereco endereco) {
}
