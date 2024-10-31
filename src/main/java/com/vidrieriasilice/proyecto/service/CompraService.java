package com.vidrieriasilice.proyecto.service;

import com.vidrieriasilice.proyecto.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    // Constructor con inyección de dependencias por constructor
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public BigDecimal obtenerTotalCompras(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return compraRepository.sumTotalByFechaBetween(fechaInicio, fechaFin);
    }

    public BigDecimal obtenerTotalComprasxCodSunat(LocalDateTime fechaInicio, LocalDateTime fechaFin,String codSunat) {
        return compraRepository.sumTotalByFechaBetweenAndCodSunat(fechaInicio, fechaFin,codSunat);
    }

    public List<Double> TotalComprasUltimosSeisMeses() {
        List<Double> totalCompras = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        // Calcular los últimos 6 meses
        for (int i = 0; i < 6; i++) {
            // Obtener el primer día del mes actual menos `i` meses
            LocalDate fechaInicio = hoy.minusMonths(i).with(TemporalAdjusters.firstDayOfMonth());
            // Obtener el último día del mes actual menos `i` meses
            LocalDate fechaFin = hoy.minusMonths(i).with(TemporalAdjusters.lastDayOfMonth());

            // Convertir LocalDate a LocalDateTime para incluir horas
            LocalDateTime fechaInicioLDT = fechaInicio.atStartOfDay();
            LocalDateTime fechaFinLDT = fechaFin.atTime(23, 59, 59);

            // Llamar al repositorio para obtener el total de compras para ese rango de fechas
            Double total = compraRepository.totalComprasUltimosSeisMeses(fechaInicioLDT, fechaFinLDT);
            totalCompras.add(total);
        }

        return totalCompras;
    }
}
