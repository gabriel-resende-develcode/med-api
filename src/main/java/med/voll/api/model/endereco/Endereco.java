package med.voll.api.model.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dadosEndereco) {
        logradouro = dadosEndereco.logradouro();
        bairro = dadosEndereco.bairro();
        cep = dadosEndereco.cep();
        numero = dadosEndereco.numero();
        complemento = dadosEndereco.complemento();
        cidade = dadosEndereco.cidade();
        uf = dadosEndereco.uf();
    }
}
