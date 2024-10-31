package com.vidrieriasilice.proyecto.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DocumentoFormDTO {

    @NotBlank (message = "El campo 'nombre de Documento' no debe estar vacío")
    @Size(min=3,max=20,message = "")
    private String nombreDoc;
    @NotBlank(message = "El campo 'CodSunat' no debe estar vacío")
    @Size(min=2,max = 2,message = "solo se admite 2 caracteres")
    private String codSunat;
    @NotBlank(message = "El campo 'Serie' no debe estar vacío")
    @Size(min=4,max = 4, message = "solo se admite 4 caracteres")
    private String ultimaSerie;
    @NotBlank(message = "El campo 'Numero' no debe estar vacío")
    @Size(min=8,max=8, message = "solo se admite 8 caracteres")
    private String ultimoNro;
}
