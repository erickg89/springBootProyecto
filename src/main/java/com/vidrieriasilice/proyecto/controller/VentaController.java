package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.model.Venta;
import com.vidrieriasilice.proyecto.repository.ClienteRepository;
import com.vidrieriasilice.proyecto.repository.VentaRepository;
import com.vidrieriasilice.proyecto.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/admin/ventas")
@RestController
public class VentaController {
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public Page<Venta> paginate(
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 5) Pageable pageable){
        return ventaRepository.findAll(pageable);
    }



    @GetMapping("/total-ventas")
    public BigDecimal obtenerTotalVentas(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
                                         @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {

        BigDecimal totalVentas = ventaService.obtenerTotalVentas(fechaInicio, fechaFin);
        return Optional.ofNullable(totalVentas).orElse(BigDecimal.ZERO);
    }

    @GetMapping("/total-ventas/codSunat")
    public BigDecimal obtenerTotalVentasxCodSunat(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
                                         @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
                                                  @RequestParam("codSunat") String codSunat) {
        BigDecimal totalVentas=BigDecimal.ZERO;
        if(codSunat.equalsIgnoreCase("ALL")){
            totalVentas = ventaService.obtenerTotalVentas(fechaInicio, fechaFin);
        }else{
            totalVentas = ventaService.obtenerTotalVentasxCodSunat(fechaInicio, fechaFin,codSunat);
        }

        return Optional.ofNullable(totalVentas).orElse(BigDecimal.ZERO);
    }
}
