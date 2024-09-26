package Main.PontoEletronico.Repository;

import Main.PontoEletronico.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
