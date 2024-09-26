package Main.PontoEletronico.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "empresa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empresa extends User{

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;


}
