package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.dto.CategoriaFormDTO;
import com.vidrieriasilice.proyecto.dto.ClienteFormDTO;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.Categoria;
import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.repository.CategoriaRepository;
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
@RequestMapping("/api/admin/categorias")
@RestController
public class CategoriaController {


    private CategoriaRepository categoriaRepository;

    @GetMapping
    public Page<Categoria> paginate(
            // @PageableDefault (sort = "id",direction = Sort.Direction.ASC,size = 5)Pageable pageable)
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 5) Pageable pageable,
            @RequestParam(defaultValue = "") String search){
        if (search.isEmpty()) {
            return categoriaRepository.findAll(pageable);
        } else {
            // Llama al método del repositorio para filtrar por nombre
            return categoriaRepository.findByNombreCategoriaContainingIgnoreCase(search, pageable);
        }
    }

    @GetMapping("/{id}")
    public Categoria get(@PathVariable Long id){
        return categoriaRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Categoria create(@RequestBody @Validated CategoriaFormDTO categoriaFormDTO){


        Categoria categoria = new ModelMapper().map(categoriaFormDTO, Categoria.class);

        return categoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id,@Valid @RequestBody CategoriaFormDTO categoriaFormDTO){

        Categoria categoriadb= categoriaRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        new ModelMapper().map(categoriaFormDTO, categoriadb);

        return categoriaRepository.save(categoriadb);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Categoria categoriadb= categoriaRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        categoriaRepository.delete(categoriadb);

    }

}
