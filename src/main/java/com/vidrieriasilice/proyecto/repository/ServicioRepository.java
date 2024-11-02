package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio,Long> {

    Page<Servicio> findByNombreServicioContainingIgnoreCase(String nombreServicio, Pageable pageable);
}
