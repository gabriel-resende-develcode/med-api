package med.voll.api.model.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.endereco.DadosEndereco;

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
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.uf = dadosEndereco.uf();
        this.cidade = dadosEndereco.cidade();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        logradouro = dadosEndereco.logradouro() != null ? dadosEndereco.logradouro() : logradouro;
        bairro = dadosEndereco.bairro() != null ? dadosEndereco.bairro() : bairro;
        cep = dadosEndereco.cep() != null ? dadosEndereco.cep() : cep;
        uf = dadosEndereco.uf() != null ? dadosEndereco.uf() : uf;
        cidade = dadosEndereco.cidade() != null ? dadosEndereco.cidade() : cidade;
        numero = dadosEndereco.numero() != null ? dadosEndereco.numero() : numero;
        complemento = dadosEndereco.complemento() != null ? dadosEndereco.complemento() : complemento;
    }
}
