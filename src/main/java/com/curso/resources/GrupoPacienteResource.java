package com.curso.resources;

import com.curso.domains.GrupoPaciente;
import com.curso.domains.dtos.GrupoPacienteDTO;
import com.curso.services.GrupoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grupopaciente")
public class GrupoPacienteResource {

    @Autowired
    private GrupoPacienteService grupoPacienteService;

    @GetMapping
    public ResponseEntity<List<GrupoPacienteDTO>>findAll(){
        return ResponseEntity.ok().body(grupoPacienteService.findAll());

    }
}
