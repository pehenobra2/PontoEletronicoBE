package Main.PontoEletronico.Controller;

import Main.PontoEletronico.DTO.CadastroFuncionarioDTO;
import Main.PontoEletronico.Model.Funcionario;
import Main.PontoEletronico.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Validated
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroFuncionario(@RequestBody @Valid CadastroFuncionarioDTO funcionarioDTO){

        Funcionario funcionario = service.cadastroFuncionario(funcionarioDTO);
        return new ResponseEntity<>("Funcionário cadastrado com sucesso!", HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listaFuncionarios(){
        List<Funcionario> funcionarios = service.listaFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }



}
