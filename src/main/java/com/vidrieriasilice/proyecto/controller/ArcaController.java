package com.vidrieriasilice.proyecto.controller;


import com.vidrieriasilice.proyecto.dto.ArcaFormDTO;
import com.vidrieriasilice.proyecto.dto.ClienteFormDTO;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.globalFunctions.functionsGlobal;
import com.vidrieriasilice.proyecto.model.Arca;
import com.vidrieriasilice.proyecto.model.Caja;
import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.repository.ArcaRepository;
import com.vidrieriasilice.proyecto.repository.CajaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/admin/arca")
@RestController
public class ArcaController {

    @Autowired
    private ArcaRepository arcaRepository;
    @Autowired
    private CajaRepository cajaRepository;

    @GetMapping("/by-caja-and-estado/{idCaja}")
    public List<Arca> getArcaByCajaAndEstado(@PathVariable Integer idCaja) {
        String estado = "ABIERTO";  // Forzar el estado a "abierto"
        return arcaRepository.findByCajaIdAndEstado(idCaja, estado);
    }

    @GetMapping("/last/{idCaja}")
    public Arca findTopByCajaIdOrderByIdDesc(@PathVariable Integer idCaja) {

        return arcaRepository.findTopByCajaIdOrderByIdDesc(idCaja);
    }

    @PutMapping("cerrar-caja/{id}")
    public Arca update(@PathVariable Long id, @Valid @RequestBody ArcaFormDTO arcaFormDTO){

        Arca arcadb = arcaRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        // Actualiza manualmente solo los campos necesarios
        LocalDateTime fechaLocal = functionsGlobal.convertirALocal(arcaFormDTO.getFechaCierre());

        arcadb.setFechaCierre(fechaLocal);
        arcadb.setMontoCierre(arcaFormDTO.getMontoCierre());
        arcadb.setTotalVentas(arcaFormDTO.getTotalVentas());
        arcadb.setEstado("CERRADO");

        return arcaRepository.save(arcadb);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Arca create(@RequestBody @Validated ArcaFormDTO arcaFormDTO){

        Arca arca = new ModelMapper().map(arcaFormDTO, Arca.class);
        // Buscar la caja por idCaja y asignarla a la entidad Arca
        Caja caja = cajaRepository.findById(arcaFormDTO.getIdCaja())
                .orElseThrow(() -> new RuntimeException("Caja no encontrada"));
        LocalDateTime fechaLocal = functionsGlobal.convertirALocal(arcaFormDTO.getFechaApertura());

        arca.setFechaApertura(fechaLocal);
        arca.setCaja(caja);
        arca.setId(null);
        arca.setEstado("ABIERTO");

        return arcaRepository.save(arca);
    }




}
