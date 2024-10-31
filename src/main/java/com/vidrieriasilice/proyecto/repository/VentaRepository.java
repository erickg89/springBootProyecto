package com.vidrieriasilice.proyecto.repository;
import com.vidrieriasilice.proyecto.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fecha BETWEEN :inicio AND :fin")
    BigDecimal sumTotalByFechaBetween(@Param("inicio") LocalDateTime fechaHoraInicio, @Param("fin") LocalDateTime fechaHoraFin);

    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fecha BETWEEN :inicio AND :fin AND v.codSunat = :codSunat")
    BigDecimal sumTotalByFechaBetweenAndCodSunat(@Param("inicio") LocalDateTime fechaHoraInicio, @Param("fin") LocalDateTime fechaHoraFin,@Param("codSunat") String codSunat);

    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fecha >= :fechaInicio AND v.fecha <= :fechaFin")
    Double totalVentasUltimosSeisMeses(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);



}
