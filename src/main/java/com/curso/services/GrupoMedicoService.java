package com.curso.services;

import com.curso.domains.dtos.GrupoMedicoDTO;
import com.curso.repositories.GrupoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoMedicoService {

    @Autowired
    private GrupoMedicoRepository grupoMedicoRepo;

    public List<GrupoMedicoDTO>findAll(){
        return grupoMedicoRepo.findAll().stream()
                .map(obj -> new GrupoMedicoDTO(obj))
                .collect(Collectors.toList());
    }
}
