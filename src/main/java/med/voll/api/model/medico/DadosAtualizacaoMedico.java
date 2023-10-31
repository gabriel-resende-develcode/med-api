package med.voll.api.model.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(String nome, String telefone, DadosEndereco endereco) {
}
