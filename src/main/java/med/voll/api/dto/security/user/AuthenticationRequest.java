package med.voll.api.dto.security.user;

public record AuthenticationRequest(String login, String password) {
}
