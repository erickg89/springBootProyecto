package com.vidrieriasilice.proyecto.service;

import com.vidrieriasilice.proyecto.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    // Constructor con inyección de dependencias por constructor
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public BigDecimal obtenerTotalVentas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return ventaRepository.sumTotalByFechaBetween(fechaInicio, fechaFin);
    }

    public BigDecimal obtenerTotalVentasxCodSunat(LocalDateTime fechaInicio, LocalDateTime fechaFin,String codSunat) {
        return ventaRepository.sumTotalByFechaBetweenAndCodSunat(fechaInicio, fechaFin,codSunat);
    }

    // Nuevo método para obtener el total de ventas de los últimos seis meses
    public List<Double> TotalVentasUltimosSeisMeses() {
        List<Double> totalVentas = new ArrayList<>();
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

            // Llamar al repositorio para obtener el total de ventas para ese rango de fechas
            Double total = ventaRepository.totalVentasUltimosSeisMeses(fechaInicioLDT, fechaFinLDT);
            totalVentas.add(total);
        }

        return totalVentas;
    }


}
