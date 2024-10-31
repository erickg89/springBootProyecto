package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_proveedor")
    private Proveedor idProveedor;

    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="cod_sunat",length = 2)
    private String codSunat;

    @Column(name="serie",length = 4)
    private String serie;

    @Column(name="numero",length = 8)
    private String numero;

    @Column(name="fecha")
    private LocalDateTime fecha;

    @Column(name="subtotal",precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name="descuento",precision = 12, scale = 2)
    private BigDecimal descuento;

    @Column(name="igv",precision = 12, scale = 2)
    private BigDecimal igv;

    @Column(name="total",precision = 12, scale = 2)
    private BigDecimal total;




}
