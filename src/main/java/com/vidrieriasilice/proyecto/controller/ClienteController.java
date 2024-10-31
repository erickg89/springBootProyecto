package com.vidrieriasilice.proyecto.controller;


import com.vidrieriasilice.proyecto.dto.ClienteFormDTO;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.repository.ClienteRepository;
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
@RequestMapping("/api/admin/clientes")
@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping
    public Page<Cliente> paginate(
            // @PageableDefault (sort = "id",direction = Sort.Direction.ASC,size = 5)Pageable pageable)
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 5) Pageable pageable){
        return clienteRepository.findAll(pageable);
    }
    /*public List<Documento> listar(){
        return  documentoRepository.findAll();
    } */
    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id){
        return clienteRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente create(@RequestBody @Validated ClienteFormDTO clienteFormDTO){


        Cliente cliente = new ModelMapper().map(clienteFormDTO, Cliente.class);

        return clienteRepository.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id,@Valid @RequestBody ClienteFormDTO clienteFormDTO){

        Cliente clientedb= clienteRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        new ModelMapper().map(clienteFormDTO, clientedb);

        return clienteRepository.save(clientedb);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Cliente clientedb= clienteRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        clienteRepository.delete(clientedb);

    }
}
