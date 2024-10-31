package com.vidrieriasilice.proyecto.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ArcaFormDTO {

    private Long idCaja;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;  // Mantén el tipo LocalDateTime para fechas

    @DecimalMin(value = "0.00", message = "El monto de apertura no puede ser negativo")
    @Digits(integer = 10, fraction = 2, message = "El monto debe tener máximo 5 dígitos en la parte entera y 2 en la decimal")
    private BigDecimal montoApertura;
    @DecimalMin(value = "0.00", message = "El monto de cierre no puede ser negativo")
    @Digits(integer = 10, fraction = 2, message = "El monto debe tener máximo 5 dígitos en la parte entera y 2 en la decimal")
    private BigDecimal montoCierre;
    private BigDecimal totalVentas;

}
