package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "detalleservicio")
public class DetalleServicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

    @Column(name="item")
    private Integer item;

    @ManyToOne
    @JoinColumn(name="id_servicio")
    private Servicio servicio;

    @Column(name="medidas")
    private String medidas;

    @Column(name="precio_unitario",precision = 12, scale = 2)
    private BigDecimal precioVenta;

    @Column(name="cantidad")
    private BigDecimal cantidad;

    @Column(name="importe",precision = 12, scale = 2)
    private BigDecimal importe;


}
