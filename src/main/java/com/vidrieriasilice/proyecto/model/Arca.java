package com.vidrieriasilice.proyecto.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "arca")
public class Arca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="id_caja")
    private Caja caja;
    @Column(name="fecha_apertura")
    private LocalDateTime fechaApertura;
    @Column(name="fecha_cierre")
    private LocalDateTime fechaCierre;
    @Column(name="monto_apertura",precision = 12, scale = 2)
    private BigDecimal montoApertura;
    @Column(name="monto_cierre",precision = 12, scale = 2)
    private BigDecimal montoCierre;
    @Column(name="total_ventas",precision = 12, scale = 2)
    private BigDecimal totalVentas;
    @Column(name="estado")
    private String estado;
}
