package com.curso.repositories;

import com.curso.domains.GrupoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoPacienteRepository extends JpaRepository<GrupoPaciente,Long> {

}
