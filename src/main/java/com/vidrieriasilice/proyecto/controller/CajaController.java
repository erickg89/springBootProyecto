package com.vidrieriasilice.proyecto.controller;

import com.vidrieriasilice.proyecto.model.Caja;
import com.vidrieriasilice.proyecto.model.Cliente;
import com.vidrieriasilice.proyecto.repository.CajaRepository;
import com.vidrieriasilice.proyecto.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/admin/caja")
@RestController
public class CajaController {
    @Autowired
    private CajaRepository cajaRepository;
    @GetMapping
    public Page<Caja> paginate(
            // @PageableDefault (sort = "id",direction = Sort.Direction.ASC,size = 5)Pageable pageable)
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC,size = 5) Pageable pageable){
        return cajaRepository.findAll(pageable);
    }

}
