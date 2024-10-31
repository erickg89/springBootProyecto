package com.vidrieriasilice.proyecto.repository;
import com.vidrieriasilice.proyecto.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Page<Pedido> findByEstado(String estado, Pageable pageable);
}
