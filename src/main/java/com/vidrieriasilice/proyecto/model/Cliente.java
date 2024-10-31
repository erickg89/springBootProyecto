package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer id;
    @Column(name="cliente", length = 120)
    private String nombreCliente;
    @Column(name="direccion", length = 120)
    private String direccion;
    @Column(name="referencia", length = 120)
    private String referencia;
    @Column(name="tipo_documento", length = 12)
    private String tipoDocumento;
    @Column(name="numero_documento", length = 11)
    private String numeroDocumento;
    @Column(name="telefono", length = 15)
    private String telefono;
    @Column(name="email", length = 60)
    private String email;
}
