package com.vidrieriasilice.proyecto.controller;


import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.DetallePedido;
import com.vidrieriasilice.proyecto.model.DetalleServicio;
import com.vidrieriasilice.proyecto.repository.DetalleServicioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/admin/detalleservicio")
@RestController
public class DetalleServicioController {

    @Autowired
    DetalleServicioRepository detalleServicioRepository;

    @GetMapping("/{id}")
    public List<DetalleServicio> get(@PathVariable Long id){
        List<DetalleServicio> detalles = detalleServicioRepository.findByPedidoId(id);

        if (detalles.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return detalles;

    }


}
