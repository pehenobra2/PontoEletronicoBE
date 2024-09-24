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

    @Enumerated(EnumType.STRING)
    private TipoPonto tipo;

    private LocalDateTime dateTime;

    private String foto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;
}