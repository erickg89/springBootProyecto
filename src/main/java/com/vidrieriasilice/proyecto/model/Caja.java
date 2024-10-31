package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "caja")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_caja")
    private Integer id;

    @Column(name="numero_caja")
    private Integer numeroCaja;

    @Column(name="nombre_caja", length = 40)
    private String nombreCaja;



}
