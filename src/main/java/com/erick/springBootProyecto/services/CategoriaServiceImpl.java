package com.erick.springBootProyecto.services;





import com.erick.springBootProyecto.model.Categoria;
import com.erick.springBootProyecto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria>listarCategoria(){

        return (List<Categoria>) categoriaRepository.findAll();

    }

    public Categoria insertarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<Categoria>obtenerById(Long id){
        return categoriaRepository.findById(id);
    }

    public boolean eliminarCategoria(Long id){

        try{
            categoriaRepository.deleteById(id);
            return true;
        }catch (Exception arg){
            return false;
        }

    }
}
