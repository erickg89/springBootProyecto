package com.vidrieriasilice.proyecto.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;
    @Column(name="id_usuario")
    private Integer idUsuario;
    @Column(name="tipo_venta",length = 20)
    private String tipoVenta;
    @Column(name="cod_sunat",length = 2)
    private String codSunat;
    @Column(name="tipo_comprobante",length = 20)
    private String tipoComprobante;
    @Column(name="serie_comprobante",length = 7)
    private String serieComprobante;
    @Column(name="num_comprobante",length = 10)
    private String numeroComprobante;
    @Column(name="fecha")
    private LocalDateTime fecha;
    @Column(name="bruto",precision = 12, scale = 2)
    private BigDecimal bruto;
    @Column(name="descuento",precision = 12, scale = 2)
    private BigDecimal descuento;
    @Column(name="impuesto",precision = 12, scale = 2)
    private BigDecimal impuesto;
    @Column(name="total",precision = 12, scale = 2)
    private BigDecimal total;
    @Column(name="moneda",length = 5)
    private String moneda;
    @Column(name="flag_std")
    private Integer flgStd;
    @Column(name="flag_sunat")
    private Integer flgSunat;
    @Column(name="flag_email")
    private Integer flgEmail;


}
