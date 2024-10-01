package com.curso.repositories;

import com.curso.domains.GrupoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMedicoRepository extends JpaRepository<GrupoMedico, Integer> {
}
