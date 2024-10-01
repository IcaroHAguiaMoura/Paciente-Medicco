package com.curso.resources;

import com.curso.domains.dtos.GrupoMedicoDTO;
import com.curso.services.GrupoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grupomedico")
public class GrupoMedicoResource {

    @Autowired
    private GrupoMedicoService grupoMedicoService;

    @GetMapping
    public ResponseEntity<List<GrupoMedicoDTO>> findAll(){
        return ResponseEntity.ok().body(grupoMedicoService.findAll());
    }
}
