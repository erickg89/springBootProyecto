package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.fecha BETWEEN :inicio AND :fin")
    BigDecimal sumTotalByFechaBetween(@Param("inicio") LocalDateTime fechaHoraInicio, @Param("fin") LocalDateTime fechaHoraFin);

    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.fecha BETWEEN :inicio AND :fin AND c.codSunat = :codSunat")
    BigDecimal sumTotalByFechaBetweenAndCodSunat(@Param("inicio") LocalDateTime fechaHoraInicio, @Param("fin") LocalDateTime fechaHoraFin,@Param("codSunat") String codSunat);

    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.fecha >= :fechaInicio AND c.fecha <= :fechaFin")
    Double totalComprasUltimosSeisMeses(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}
