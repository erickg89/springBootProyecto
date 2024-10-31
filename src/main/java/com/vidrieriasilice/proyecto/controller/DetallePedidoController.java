package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.model.DetallePedido;
import com.vidrieriasilice.proyecto.repository.DetallePedidoRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/admin/detallepedido")
@RestController
public class DetallePedidoController {

    @Autowired
    DetallePedidoRespository detallePedidoRespository;

    @GetMapping("/{id}")
    public List<DetallePedido> get(@PathVariable Long id){
        List<DetallePedido> detalles = detallePedidoRespository.findByPedidoId(id);

        if (detalles.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return detalles;

    }

}
