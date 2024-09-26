package Main.PontoEletronico.Controller;

import Main.PontoEletronico.DTO.CadastroFuncionarioDTO;
import Main.PontoEletronico.Model.Funcionario;
import Main.PontoEletronico.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.image.RescaleOp;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcionario>> funcionarioById(@PathVariable Long id){
        Optional<Funcionario> funcionario = service.FuncionarioById(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Funcionario>> atualizacaoFuncionario(@PathVariable Long id, @RequestBody @Valid CadastroFuncionarioDTO funcionarioDTO){

        Optional<Funcionario> funcionario = service.atualizacaoFuncionario(id, funcionarioDTO);

        return new ResponseEntity<>(funcionario, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarFuncionario(@PathVariable Long id){
        service.deletarFuncionario(id);
        return new ResponseEntity<>("Funcionário deletado!", HttpStatus.OK);
    }

}
