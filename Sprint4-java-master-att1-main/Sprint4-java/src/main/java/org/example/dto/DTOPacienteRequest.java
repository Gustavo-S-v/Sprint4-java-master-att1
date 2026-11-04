package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOPacienteRequest {
    private int id;
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 255, message = "O tamanho máximo para um nome é 255 caracteres")

    private String nome;
    @Positive(message = "A idade deve ser um valor positivo")
    private int idade;

    @NotBlank(message = "A doença é obrigatória")
    @Size(max = 255, message = "O tamanho máximo para a descrição da doença é 255 caracteres")
    private String doenca;
}