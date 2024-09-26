package Main.PontoEletronico.Controller;

import Main.PontoEletronico.DTO.AutenticacaoDTO;
import Main.PontoEletronico.DTO.TokenJwtDTO;
import Main.PontoEletronico.Infra.security.TokenService;
import Main.PontoEletronico.Model.User;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
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
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AutenticacaoDTO dados){
        var authToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = manager.authenticate(authToken);

        var token = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(token));
    }

}

