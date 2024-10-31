package com.vidrieriasilice.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Column(name="id_usuario")
    private Integer idUsuario;
    @Column(name="tipo_pedido",length = 20)
    private String tipoPedido;
    @Column(name="fecha")
    private LocalDate fecha;
    @Column(name="estado", length = 20)
    private String estado;
}
