package med.voll.api.model.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.medico.DadosAtualizacaoMedico;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.MedicoResponseDTO;
import med.voll.api.model.endereco.Endereco;
import med.voll.api.model.medico.enums.EspecialidadeMedico;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadeMedico especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dadosMedico) {
        ativo = true;
        nome = dadosMedico.nome();
        email = dadosMedico.email();
        telefone = dadosMedico.telefone();
        crm = dadosMedico.crm();
        especialidade = dadosMedico.especialidade();
        endereco = new Endereco(dadosMedico.endereco());
    }

    public Medico(MedicoResponseDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

    public void desativarMedico() {
        ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        nome = dados.nome() != null ? dados.nome() : nome;
        telefone = dados.telefone() != null ? dados.telefone() : telefone;
        endereco.atualizarInformacoes(dados.endereco());
    }
}
