package com.vidrieriasilice.proyecto.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ServicioFormDTO {


    private String codigo;
    private String nombreServicio;
    @NotBlank(message = "El campo 'unidad Medida' no debe estar vacío")
    @Size(min=3,max=25,message = "minimo 3 y maximo 25 caracteres")
    private String unidadMedida;
    @NotBlank(message = "El campo 'categoria' no debe estar vacío")
    @Size(min=3,max=25,message = "minimo 3 y maximo 25 caracteres")
    private String categoria;
    @NotNull(message = "El campo 'dimension' no debe estar vacío")
    @Min(value = 1, message = "El valor mínimo permitido para 'dimension' es 1")
    private Integer dimension;
}
