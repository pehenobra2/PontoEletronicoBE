package Main.PontoEletronico.Repository;

import Main.PontoEletronico.Model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
}
