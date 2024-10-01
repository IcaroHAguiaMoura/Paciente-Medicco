package com.curso.services;

import com.curso.domains.GrupoMedico;
import com.curso.domains.GrupoPaciente;
import com.curso.domains.Medico;
import com.curso.domains.Paciente;
import com.curso.domains.enums.Status;
import com.curso.repositories.GrupoMedicoRepository;
import com.curso.repositories.GrupoPacienteRepository;
import com.curso.repositories.MedicoRepository;
import com.curso.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private GrupoPacienteRepository grupoPacienteRepo;

    @Autowired
    private PacienteRepository pacienteRepo;

    @Autowired
    private GrupoMedicoRepository grupoMedicoRepo;

    @Autowired
    private MedicoRepository medicoRepo;

    public void initDB() {

        GrupoMedico grupoMedico1 = new GrupoMedico(0, "Cardiologia", Status.ATIVO);
        grupoMedicoRepo.save(grupoMedico1);

        Medico medico1 = new Medico(0, "Ronaldinho", LocalDate.now(), new BigDecimal("1000"), grupoMedico1, Status.ATIVO);
        medicoRepo.save(medico1);

        GrupoPaciente grupo01 = new GrupoPaciente(0, "URGENTE", Status.ATIVO);
        GrupoPaciente grupo02 = new GrupoPaciente(0, "NÃO URGENTE", Status.ATIVO);

        Paciente paciente01 = new Paciente(0, "Epaminondas", LocalDate.now(), new BigDecimal("1000"), grupo01, Status.ATIVO, medico1);
        Paciente paciente02 = new Paciente(0, "Frederico", LocalDate.now(), new BigDecimal("2000"), grupo02, Status.ATIVO, medico1);


        grupoPacienteRepo.save(grupo01);
        grupoPacienteRepo.save(grupo02);
        pacienteRepo.save(paciente01);
        pacienteRepo.save(paciente02);
    }
}
