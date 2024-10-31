package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
