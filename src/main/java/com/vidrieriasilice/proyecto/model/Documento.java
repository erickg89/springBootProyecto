package com.vidrieriasilice.proyecto.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_documento")
    private Integer id_documento;

    @Column(name="nombre_documento",length = 25)
    private String nombreDoc;
    @Column(name="cod_sunat",length = 2)
    private String codSunat;
    @Column(name="ultima_serie",length = 10)
    private String ultimaSerie;
    @Column(name="ultimo_numero",length = 20)
    private String ultimoNro;


}
