package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private Integer id;

    @Column(name="proveedor")
    private String  nombre;

    @Column(name="direccion")
    private String  direccion;

    @Column(name="referencia")
    private String  referencia;

    @Column(name="ruc")
    private String  ruc;

    @Column(name="telefono")
    private String  telefono;

    @Column(name="email")
    private String  email;
}
