package Main.PontoEletronico.Controller;

import Main.PontoEletronico.DTO.CadastroEmpresaDTO;
import Main.PontoEletronico.Model.Empresa;
import Main.PontoEletronico.Service.AutenticacaoService;
import Main.PontoEletronico.Service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@Validated
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroEmpresa(@RequestBody @Valid CadastroEmpresaDTO empresaDTO) {
        Empresa empresa = service.cadastroEmpresa(empresaDTO);
        return new ResponseEntity<>("Empresa cadastrada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listaEmpresas() {
        List<Empresa> empresas = service.listaEmpresas();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empresa>> empresaById(@PathVariable Long id) {
        Optional<Empresa> empresa = service.empresaById(id);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Empresa>> atualizacaoEmpresa(@PathVariable Long id, @RequestBody @Valid CadastroEmpresaDTO empresaDTO) {
        Optional<Empresa> empresa = service.atualizacaoEmpresa(id, empresaDTO);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarEmpresa(@PathVariable Long id) {
        service.deletarEmpresa(id);
        return new ResponseEntity<>("Empresa deletada!", HttpStatus.OK);
    }
}