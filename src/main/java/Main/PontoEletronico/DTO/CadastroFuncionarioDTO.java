package Main.PontoEletronico.DTO;


import jakarta.validation.constraints.*;

public record CadastroFuncionarioDTO(

        @NotBlank(message = "O email é obrigatório")
        @Pattern(
                regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                message = "Email inválido"
        )
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String password,

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotNull
        Long empresa_id
) {
}
