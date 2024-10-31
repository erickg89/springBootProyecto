package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.model.Pedido;
import com.vidrieriasilice.proyecto.repository.ClienteRepository;
import com.vidrieriasilice.proyecto.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/admin/pedidos")
@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public Page<Pedido> paginate(
            // @PageableDefault (sort = "id",direction = Sort.Direction.ASC,size = 5)Pageable pageable)
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 5) Pageable pageable){
        return  pedidoRepository.findByEstado("No Vendido", pageable);
    }

    @GetMapping("/{id}")
    public Pedido get(@PathVariable Long id){
        return pedidoRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

    }
}
