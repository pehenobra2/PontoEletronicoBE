package Main.PontoEletronico.Repository;

import Main.PontoEletronico.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
