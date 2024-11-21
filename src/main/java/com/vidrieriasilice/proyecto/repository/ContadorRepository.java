package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.Contador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorRepository extends JpaRepository<Contador, Integer> {

    Contador findByConTabla(String conTabla);
}
