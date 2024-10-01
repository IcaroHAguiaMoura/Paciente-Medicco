package com.curso.services;

import com.curso.domains.dtos.MedicoDTO;
import com.curso.domains.dtos.PacienteDTO;
import com.curso.repositories.MedicoRepository;
import com.curso.repositories.PacienteRepository;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepo;

    public List<MedicoDTO>findAll(){
        return medicoRepo.findAll().stream()
                .map(obj -> new MedicoDTO(obj))
                .collect(Collectors.toList());
    }
}
