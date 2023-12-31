package med.voll.api.controller.security;

import jakarta.validation.Valid;
import med.voll.api.dto.security.token.TokenJwtDTO;
import med.voll.api.dto.security.user.AuthenticationRequest;
import med.voll.api.model.user.User;
import med.voll.api.service.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequest request) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(request.login(), request.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }
}
