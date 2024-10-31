package com.vidrieriasilice.proyecto.controller;


import com.vidrieriasilice.proyecto.service.CompraService;
import com.vidrieriasilice.proyecto.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/admin/graficas")
@RestController
public class GraficasController {

    private final CompraService compraService;
    private final VentaService ventaService;

    // Constructor con inyección de dependencias por constructor
    public GraficasController(CompraService compraService, VentaService ventaService) {
        this.compraService = compraService;
        this.ventaService = ventaService;
    }

    // Endpoint para obtener ventas y compras de los últimos 6 meses
    @GetMapping("/ventas-compras")
    public Map<String, Object> obtenerVentasYComprasUltimosSeisMeses() {
        // Obtener los totales de ventas y compras
        List<Double> totalCompras = compraService.TotalComprasUltimosSeisMeses();
        List<Double> totalVentas = ventaService.TotalVentasUltimosSeisMeses();
        // Generar los nombres de los últimos seis meses
        List<String> meses = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        LocalDate now = LocalDate.now();

        // Generar los últimos seis meses en formato de texto
        for (int i = 5; i >= 0; i--) {
            meses.add(now.minusMonths(i).format(formatter));
        }
        // Crear un mapa para devolver ambas listas
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("compras", totalCompras);
        respuesta.put("ventas", totalVentas);
        respuesta.put("meses", meses); // Añadir los meses a la respuesta

        return respuesta; // Devuelve el mapa como JSON
    }
}
