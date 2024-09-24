package Main.PontoEletronico.Service;

import Main.PontoEletronico.DTO.CadastroFuncionarioDTO;
import Main.PontoEletronico.Model.Funcionario;
import Main.PontoEletronico.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario cadastroFuncionario(CadastroFuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();
        funcionario.setEmail(funcionarioDTO.email());
        funcionario.setName(funcionarioDTO.name());
        funcionario.setPassword(funcionarioDTO.password());

        return repository.save(funcionario);
    }

    public List<Funcionario> listaFuncionarios(){
        return repository.findAll();
    }

}
