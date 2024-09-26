package Main.PontoEletronico.Controller;

import Main.PontoEletronico.DTO.CadastroPontoDTO;
import Main.PontoEletronico.Model.RegistroPonto;
import Main.PontoEletronico.Service.RegistroPontoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pontosRegistrados")
@Validated
public class RegistroPontoController {


    @Autowired
    private RegistroPontoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroPonto(@RequestBody @Valid CadastroPontoDTO pontoDTO){

        service.cadastroPonto(pontoDTO);
        return new ResponseEntity<>("Ponto batido com sucesso!", HttpStatus.CREATED);

    }


}
