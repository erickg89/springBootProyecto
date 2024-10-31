package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer id;

    @Column(name="codigo", length = 10)
    private String codigo;
    @Column(name="nombre_producto", length = 200)
    private String nombreProducto;
    @Column(name="unidadmedida", length = 20)
    private String unidadMedida;
    @Column(name="categoria", length = 20)
    private String categoria;
    @Column(name="ingreso", precision = 12, scale = 2)
    private BigDecimal ingreso;
    @Column(name="salida", precision = 12, scale = 2)
    private BigDecimal salida;
    @Column(name="stock", precision = 12, scale = 2)
    private BigDecimal stock;
    @Column(name="precio_compra", precision = 12, scale = 2)
    private BigDecimal precioCompra;
    @Column(name="precio_publico", precision = 12, scale = 2)
    private BigDecimal precioPublico;
    @Column(name="precio_distribuidor", precision = 12, scale = 2)
    private BigDecimal precioDistribuidor;

    @Column(name="equivalencia")
    private Integer equivalencia;
}
