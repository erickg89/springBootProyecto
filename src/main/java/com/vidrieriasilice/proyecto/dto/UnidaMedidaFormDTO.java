package com.vidrieriasilice.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UnidaMedidaFormDTO {

    @NotBlank(message = "El campo 'unidad de almacenamiento' no debe estar vacío")
    @Size(min=4,max=40,message = "El campo 'unidad de almacenamiento', minimo 4 y maximo 40 caracteres")
   // @JsonProperty("unidAlmacenamiento")
    private String unidAlmacenamiento;

    @NotBlank(message = "El campo 'unidad de Venta' no debe estar vacío")
    @Size(min=4,max=40,message = "El campo 'unidad de Venta', minimo 4 y maximo 40 caracteres")
  // @JsonProperty("unidVenta")
    private String unidVenta;
}
