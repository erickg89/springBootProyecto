package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_servicio")
    private Integer id;
    @Column(name="codigo", length = 10)
    private String codigo;
    @Column(name="nombre_servicio", length = 200)
    private String nombreServicio;
    @Column(name="Unidad", length = 10)
    private String unidadMedida;
    @Column(name="categoria", length = 20)
    private String categoria;
    @Column(name="dimension", length = 10)
    private String dimension;

}
