package com.erick.springBootProyecto.controller;


import com.erick.springBootProyecto.model.Categoria;
import com.erick.springBootProyecto.services.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaServiceImpl categoriaServiceImpl;


    @GetMapping()
    public List<Categoria> ListarCategoria(){

        return categoriaServiceImpl.listarCategoria();
    }

    @PostMapping()
    public Categoria InsertarCategoria(@RequestBody Categoria categoria){
        return categoriaServiceImpl.insertarCategoria(categoria);
    }

    @GetMapping(path = "/{id}")
    public Optional<Categoria> findCategoriaById(@PathVariable("id") Long id){
        return categoriaServiceImpl.obtenerById(id);
    }

    @DeleteMapping(path="/{id}")
        String DeleteCategoriaById (@PathVariable("id") Long id){
        boolean ok=categoriaServiceImpl.eliminarCategoria(id);
        if(ok){
            return "se elimino correctamente el usuario con Id"+id;
        }else{
            return "no se pudo eliminar el usuario con Id"+id;
        }
    }




}
