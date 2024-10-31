package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "unidadmedida")
public class UnidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_unidadmedida")
    private Integer id;

    @Column(name="unidad_almacenamiento")
    private String uAlmacenamiento;

    @Column(name="unidad_venta")
    private String uVenta;
}
