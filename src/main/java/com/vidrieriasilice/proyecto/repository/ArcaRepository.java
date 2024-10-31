package com.vidrieriasilice.proyecto.repository;

import com.vidrieriasilice.proyecto.model.Arca;
import com.vidrieriasilice.proyecto.model.Caja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArcaRepository extends JpaRepository<Arca, Long> {

    List<Arca> findByCajaIdAndEstado(Integer idCaja, String estado);

    Arca findTopByCajaIdOrderByIdDesc(Integer idCaja);
}
