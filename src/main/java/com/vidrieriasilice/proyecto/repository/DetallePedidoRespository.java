package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetallePedidoRespository extends JpaRepository<DetallePedido, Long> {

    List<DetallePedido> findByPedidoId(Long idPedido);

}
