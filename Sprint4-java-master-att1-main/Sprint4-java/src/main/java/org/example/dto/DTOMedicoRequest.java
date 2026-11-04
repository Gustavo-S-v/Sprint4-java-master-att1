package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOMedicoRequest {

    private int id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O tamanho máximo para o nome é 255 caracteres")
    private String nome;

    @NotBlank(message = "O CRM é obrigatório")
    @Size(max = 20, message = "O CRM deve ter no máximo 20 caracteres")
    private String crm;

    @NotBlank(message = "A especialidade é obrigatória")
    @Size(max = 100, message = "A especialidade deve ter no máximo 100 caracteres")
    private String especialidade;
}
