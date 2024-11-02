package com.vidrieriasilice.proyecto.service;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.dto.ServicioFormDTO;
import com.vidrieriasilice.proyecto.model.Servicio;
import com.vidrieriasilice.proyecto.repository.ServicioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {
     @Autowired
     ServicioRepository servicioRepository;


    public Page<Servicio> paginate(String search, Pageable pageable) {
        if (search.isEmpty()) {
            return servicioRepository.findAll(pageable);
        } else {
            return servicioRepository.findByNombreServicioContainingIgnoreCase(search, pageable);
        }
    }


    public Servicio get(Long id) {
        return servicioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }


    public Servicio create(ServicioFormDTO servicioFormDTO) {
        Servicio servicio = new ModelMapper().map(servicioFormDTO, Servicio.class);

        return servicioRepository.save(servicio);
    }


    public Servicio update(Long id, ServicioFormDTO servicioFormDTO) {
        Servicio servicioDb = servicioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);


        new ModelMapper().map(servicioFormDTO, servicioDb);
        return servicioRepository.save(servicioDb);
    }


    public void delete(Long id) {
        Servicio servicioDb = servicioRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        servicioRepository.delete(servicioDb);
    }
    }

