package com.vidrieriasilice.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaFormDTO {

    @NotBlank(message = "El campo 'nombre de Categoria' no debe estar vacío")
    @Size(min=2,max=200,message = "minimo 4 y maximo 25 caracteres")
    private String nombreCategoria;

}
