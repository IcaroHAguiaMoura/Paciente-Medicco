package com.curso.repositories;

import com.curso.domains.GrupoPaciente;
import com.curso.domains.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
