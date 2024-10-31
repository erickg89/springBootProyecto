package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.service.CompraService;
import com.vidrieriasilice.proyecto.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/api/admin/compras")
@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;


    @GetMapping("/total-compras")
    public BigDecimal obtenerTotalCompras(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
                                         @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {

        BigDecimal totalCompras = compraService.obtenerTotalCompras(fechaInicio, fechaFin);
        return Optional.ofNullable(totalCompras).orElse(BigDecimal.ZERO);
    }

    @GetMapping("/total-compras/codSunat")
    public BigDecimal obtenerTotalComprasxCodSunat(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
                                                  @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
                                                  @RequestParam("codSunat") String codSunat) {

        BigDecimal totalCompras=BigDecimal.ZERO;
        if (codSunat.equalsIgnoreCase("ALL")){
            totalCompras = compraService.obtenerTotalCompras(fechaInicio, fechaFin);
        }else{
            totalCompras = compraService.obtenerTotalComprasxCodSunat(fechaInicio, fechaFin,codSunat);
        }

        return Optional.ofNullable(totalCompras).orElse(BigDecimal.ZERO);
    }
}
