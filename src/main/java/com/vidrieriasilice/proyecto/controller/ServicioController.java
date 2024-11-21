package com.vidrieriasilice.proyecto.controller;


import com.vidrieriasilice.proyecto.dto.ServicioFormDTO;
import com.vidrieriasilice.proyecto.model.Categoria;
import com.vidrieriasilice.proyecto.model.Servicio;
import com.vidrieriasilice.proyecto.service.ContadorService;
import com.vidrieriasilice.proyecto.service.ServicioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/admin/servicios")
@RestController
public class ServicioController {

    @Autowired
    ServicioService servicioService;
    @Autowired
    private ContadorService contadorService;

    @GetMapping
    public Page<Servicio> paginate(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 5) Pageable pageable,
            @RequestParam(defaultValue = "") String search) {
        return servicioService.paginate(search, pageable);
    }

    @GetMapping("/{id}")
    public Servicio get(@PathVariable Long id) {
        return servicioService.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Servicio create(@RequestBody @Validated ServicioFormDTO servicioFormDTO) {

        String codigo= contadorService.generarCodigo("servicios");
        System.out.println("codigo"+codigo);
        servicioFormDTO.setCodigo(codigo);
        return servicioService.create(servicioFormDTO);
    }

    @PutMapping("/{id}")
    public Servicio update(@PathVariable Long id, @Valid @RequestBody ServicioFormDTO servicioFormDTO) {
        return servicioService.update(id, servicioFormDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        servicioService.delete(id);
    }

}
