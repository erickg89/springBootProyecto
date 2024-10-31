package com.vidrieriasilice.proyecto.controller;
import com.vidrieriasilice.proyecto.dto.DocumentoFormDTO;
import com.vidrieriasilice.proyecto.exception.ResourceNotFoundException;
import com.vidrieriasilice.proyecto.model.Documento;
import com.vidrieriasilice.proyecto.repository.DocumentoRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/documentos")
public class DocumentoController {
    @Autowired
    private DocumentoRepository documentoRepository;
    @GetMapping
    public Page<Documento>paginate(
           // @PageableDefault (sort = "id",direction = Sort.Direction.ASC,size = 5)Pageable pageable)
            @PageableDefault (size = 5)Pageable pageable){
        return documentoRepository.findAll(pageable);
    }

    @GetMapping("/all")
    public List<Documento> getAll(){
        return  documentoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Documento get(@PathVariable Long id){
        return documentoRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Documento create(@RequestBody @Validated DocumentoFormDTO documentoFormDTO){

        /*Documento documento= new Documento();
        documento.setNombreDoc(documentoFormDTO.getNombreDoc());
        documento.setCodSunat(documentoFormDTO.getCodSunat());
        documento.setUltimaSerie(documentoFormDTO.getUltimaSerie());
        documento.setUltimoNro(documentoFormDTO.getUltimoNro());*/

        Documento documento = new ModelMapper().map(documentoFormDTO, Documento.class);

        return documentoRepository.save(documento);
    }
    @PutMapping("/{id}")
    public Documento update(@PathVariable Long id,@Valid @RequestBody DocumentoFormDTO documentoFormDTO){

        Documento documentodb= documentoRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

       /* documentodb.setNombreDoc(documentoFormDTO.getNombreDoc());
        documentodb.setCodSunat(documentoFormDTO.getCodSunat());
        documentodb.setUltimaSerie(documentoFormDTO.getUltimaSerie());
        documentodb.setUltimoNro(documentoFormDTO.getUltimoNro());*/

        new ModelMapper().map(documentoFormDTO, documentodb);

        return documentoRepository.save(documentodb);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Documento documentodb= documentoRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        documentoRepository.delete(documentodb);

    }


}
