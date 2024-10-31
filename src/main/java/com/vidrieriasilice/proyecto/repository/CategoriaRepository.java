package com.vidrieriasilice.proyecto.repository;


import com.vidrieriasilice.proyecto.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Page<Categoria> findByNombreCategoriaContainingIgnoreCase(String nombreCategoria, Pageable pageable);
}
