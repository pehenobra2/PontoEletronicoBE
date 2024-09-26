package Main.PontoEletronico.Service;

import Main.PontoEletronico.DTO.CadastroFuncionarioDTO;
import Main.PontoEletronico.Model.Empresa;
import Main.PontoEletronico.Model.Funcionario;
import Main.PontoEletronico.Repository.EmpresaRepository;
import Main.PontoEletronico.Repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.net.FileNameMap;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Funcionario cadastroFuncionario(CadastroFuncionarioDTO funcionarioDTO){

        Optional<Empresa> empresaAux = empresaRepository.findById(funcionarioDTO.empresa_id());

        if(empresaAux.isPresent()){

            Empresa empresa = empresaAux.get();

            Funcionario funcionario = new Funcionario();
            funcionario.setEmail(funcionarioDTO.email());
            funcionario.setName(funcionarioDTO.name());
            funcionario.setPassword(passwordEncoder.encode(funcionarioDTO.password()));
            funcionario.setEmpresa(empresa);

            return repository.save(funcionario);

        }else{
            throw new EntityNotFoundException("Empresa não encontrada com esse id!");
        }
    }

    public List<Funcionario> listaFuncionarios(){
        return repository.findAll();
    }

    public Optional<Funcionario> FuncionarioById(Long id){
        Optional<Funcionario> funcionario= repository.findById(id);
        if(funcionario.isEmpty()){
            throw new EntityNotFoundException("Funcionário não encontrado!");
        }
        return funcionario;
    }

    public Optional<Funcionario> atualizacaoFuncionario(Long id, CadastroFuncionarioDTO funcionarioDTO){
        Optional<Funcionario> funcionario= repository.findById(id);
        if(funcionario.isEmpty()){
            throw new EntityNotFoundException("Funcionário não encontrado!");
        }

        Funcionario funciorioAtt = funcionario.get();
        funciorioAtt.setName(funcionarioDTO.name());
        funciorioAtt.setEmail(funcionarioDTO.email());
        funciorioAtt.setPassword(funcionarioDTO.password());

        return Optional.of(repository.save(funciorioAtt));

    }

    public void deletarFuncionario(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isEmpty()){
            throw new EntityNotFoundException("Funcionário não encontrado com esse id");
        }
        repository.delete(funcionario.get());
    }

}
