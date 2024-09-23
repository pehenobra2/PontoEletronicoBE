package Main.PontoEletronico.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pontos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long funcionario_id;

    private TipoPonto tipo;

    private LocalDateTime dateTime;

    private String foto;
}
