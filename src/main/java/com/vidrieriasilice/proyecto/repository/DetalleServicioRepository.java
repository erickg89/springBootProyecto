package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.DetallePedido;
import com.vidrieriasilice.proyecto.model.DetalleServicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleServicioRepository extends JpaRepository<DetalleServicio, Long> {

    List<DetalleServicio> findByPedidoId(Long idPedido);
}
