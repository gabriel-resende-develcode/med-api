package med.voll.api.model.medico;

public record DadosListagemMedico(String nome, String email, String crm, EspecialidadeMedico especialide) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
