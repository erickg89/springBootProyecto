package com.vidrieriasilice.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteFormDTO {

    @NotBlank(message = "El campo 'nombre de Cliente' no debe estar vacío")
    @Size(min=2,max=200,message = "minimo 2 y maximo 200 caracteres")
    private String nombreCliente;
    @Size(max = 350,message = "maximo 350 caracteres")
    private String direccion;
    @Size(max = 350, message = "maximo 350 caracteres")
    private String referencia;
    @Size(max=3, message = "maximo 3 caracteres")
    private String tipoDocumento;
    @Size(max=11, message = "maximo 11 caracteres")
    private String numeroDocumento;
    @Size(max=9, message = "solo se admite 9 caracteres")
    private String telefono;
    @Size(max=200, message = "maximo 200 caracteres")
    private String email;
}
