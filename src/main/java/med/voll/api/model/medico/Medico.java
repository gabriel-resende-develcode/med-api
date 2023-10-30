package med.voll.api.model.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "medicos")
@Getter
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

    public Medico(DadosCadastroMedico dadosMedico) {
        nome = dadosMedico.nome();
        email = dadosMedico.email();
        telefone = dadosMedico.telefone();
        crm = dadosMedico.crm();
        especialidade = dadosMedico.especialidade();
        endereco = new Endereco(dadosMedico.endereco());
    }
}
