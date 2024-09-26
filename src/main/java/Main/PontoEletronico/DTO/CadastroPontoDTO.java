package Main.PontoEletronico.DTO;

import Main.PontoEletronico.Model.TipoPonto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroPontoDTO(
        @NotNull
        Long funcionario_id,

        @NotNull
        TipoPonto tipo
) {
}
