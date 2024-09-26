package Main.PontoEletronico.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CadastroEmpresaDTO(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @Pattern(
                regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                message = "Email inválido"
        )
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String password,

        @NotBlank(message = "O CNPJ é obrigatório")
        @Pattern(regexp = "\\d{14}", message = "CNPJ inválido. Deve conter 14 dígitos numéricos")
        String cnpj,

        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Telefone inválido. Deve seguir o formato (XX) XXXXX-XXXX")
        String telefone

) {
}
