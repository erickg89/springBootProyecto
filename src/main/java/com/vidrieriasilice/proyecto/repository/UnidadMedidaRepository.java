package com.vidrieriasilice.proyecto.repository;


import com.vidrieriasilice.proyecto.model.Categoria;
import com.vidrieriasilice.proyecto.model.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida, Long> {

    Page<UnidadMedida> findByUnidAlmacenamientoContainingIgnoreCase(String unidAlmacenamiento, Pageable pageable);

}
