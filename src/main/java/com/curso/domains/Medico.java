package com.curso.domains;

import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_medico")
    private long idMedico;

    @NotBlank @NotNull
    private String nomeMedico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao = LocalDate.now();

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name="idgrupomedico")
    private GrupoMedico grupoMedico;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Paciente> pacientes = new ArrayList<>();


    public Medico(){
        this.salario = BigDecimal.ZERO;
        this.status = Status.ATIVO;

    }

    public Medico(long idMedico, String nomeMedico, LocalDate dataContratacao, BigDecimal salario, GrupoMedico grupoMedico, Status status) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.dataContratacao = dataContratacao;
        this.salario = salario != null ? salario : BigDecimal.ZERO;
        this.grupoMedico = grupoMedico;
        this.status = status;

    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public GrupoMedico getGrupoMedico() {
        return grupoMedico;
    }

    public void setGrupoMedico(GrupoMedico grupoMedico) {
        this.grupoMedico = grupoMedico;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return idMedico == medico.idMedico && Objects.equals(nomeMedico, medico.nomeMedico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedico, nomeMedico);
    }
}
