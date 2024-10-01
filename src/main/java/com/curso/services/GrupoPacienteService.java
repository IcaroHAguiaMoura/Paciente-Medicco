package com.curso.services;

import com.curso.domains.dtos.GrupoPacienteDTO;
import com.curso.repositories.GrupoPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoPacienteService {

    @Autowired
    private GrupoPacienteRepository grupoPacienteRepo;

    public List<GrupoPacienteDTO> findAll(){
        return grupoPacienteRepo.findAll().stream()
                .map(obj -> new GrupoPacienteDTO(obj))
                .collect(Collectors.toList());
    }
}
