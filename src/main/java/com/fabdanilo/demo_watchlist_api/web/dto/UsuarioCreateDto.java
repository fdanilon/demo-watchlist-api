package com.fabdanilo.demo_watchlist_api.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDto {

    private String nome;
    @NotBlank
    @Size(min = 6, max = 6)
    private String senha;
    @NotBlank
    @Email(message = "Formato do email inválido")
    private String email;
}
