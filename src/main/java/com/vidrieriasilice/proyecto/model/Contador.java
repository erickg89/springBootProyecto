package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contador")
public class Contador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="conttabla")
    private String conTabla;

    @Column(name="contitem")
    private String conItem;

    @Column(name="contlongitud")
    private String conLongitud;
}
