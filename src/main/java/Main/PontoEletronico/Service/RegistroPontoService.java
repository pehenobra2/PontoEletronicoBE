package Main.PontoEletronico.Service;

import Main.PontoEletronico.DTO.CadastroPontoDTO;
import Main.PontoEletronico.Model.Funcionario;
import Main.PontoEletronico.Model.RegistroPonto;
import Main.PontoEletronico.Repository.FuncionarioRepository;
import Main.PontoEletronico.Repository.RegistroPontoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistroPontoService {

    @Autowired
    private RegistroPontoRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void cadastroPonto(CadastroPontoDTO pontoDTO){

        Optional<Funcionario> funcionarioAux = funcionarioRepository.findById(pontoDTO.funcionario_id());

        if(funcionarioAux.isPresent()){
            Funcionario funcionario = funcionarioAux.get();

            RegistroPonto ponto = new RegistroPonto();
            ponto.setFuncionario(funcionario);
            ponto.setTipo(pontoDTO.tipo());
            ponto.setDateTime(LocalDateTime.now());

            repository.save(ponto);

        }else{
            throw new EntityNotFoundException("Funcionário não encontrado com esse id");
        }

    }

}
