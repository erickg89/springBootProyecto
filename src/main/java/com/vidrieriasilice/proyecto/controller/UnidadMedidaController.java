package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.dto.CategoriaFormDTO;
import com.vidrieriasilice.proyecto.dto.UnidaMedidaFormDTO;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.Categoria;
import com.vidrieriasilice.proyecto.model.UnidadMedida;
import com.vidrieriasilice.proyecto.repository.UnidadMedidaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/admin/unidadMedida")
@RestController
public class UnidadMedidaController {

    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;

    @GetMapping
    public Page<UnidadMedida> paginate(
            // @PageableDefault (sort = "id",direction = Sort.Direction.ASC,size = 5)Pageable pageable)
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 5) Pageable pageable,
            @RequestParam(defaultValue = "") String search){
        if (search.isEmpty()) {
            return unidadMedidaRepository.findAll(pageable);
        } else {
            // Llama al método del repositorio para filtrar por nombre
            return unidadMedidaRepository.findByUnidAlmacenamientoContainingIgnoreCase(search, pageable);
        }
    }

    @GetMapping("/{id}")
    public UnidadMedida get(@PathVariable Long id){
        return unidadMedidaRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UnidadMedida create(@RequestBody @Validated UnidaMedidaFormDTO unidaMedidaFormDTO){


        UnidadMedida unidadmedida = new ModelMapper().map(unidaMedidaFormDTO, UnidadMedida.class);

        return unidadMedidaRepository.save(unidadmedida);
    }

    @PutMapping("/{id}")
    public UnidadMedida update(@PathVariable Long id,@Valid @RequestBody UnidaMedidaFormDTO unidaMedidaFormDTO){

        UnidadMedida unidadmedidadb= unidadMedidaRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        new ModelMapper().map(unidaMedidaFormDTO, unidadmedidadb);

        return unidadMedidaRepository.save(unidadmedidadb);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        UnidadMedida unidadmedidadb= unidadMedidaRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        unidadMedidaRepository.delete(unidadmedidadb);

    }
}
