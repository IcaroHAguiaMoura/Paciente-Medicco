package com.curso.domains;

import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_paciente")
    private long idPaciente;

    @NotBlank @NotNull
    private String nomePaciente;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento = LocalDate.now();

    @NotNull
    @Digits(integer = 15,fraction = 3)
    private BigDecimal custoInternacao;

    @ManyToOne
    @JoinColumn(name="idgrupopaciente")
    private GrupoPaciente grupoPaciente;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "Status")
    private Status status;

    @ManyToOne
    @JoinColumn(name="idmedico")
    private Medico medico;


    public Paciente(){
        this.custoInternacao = BigDecimal.ZERO;
        this.status = Status.ATIVO;
    }

    public Paciente(long idPaciente, String nomePaciente, LocalDate dataNascimento, BigDecimal custoInternacao, GrupoPaciente grupoPaciente, Status status, Medico medico) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.dataNascimento = dataNascimento;
        this.custoInternacao = custoInternacao != null ? custoInternacao: BigDecimal.ZERO;
        this.grupoPaciente = grupoPaciente;
        this.status = status;
        this.medico = medico;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public @NotBlank @NotNull String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(@NotBlank @NotNull String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(@NotNull @Digits(integer = 15, fraction = 3) BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public GrupoPaciente getGrupoPaciente() {
        return grupoPaciente;
    }

    public void setGrupoPaciente(GrupoPaciente grupoPaciente) {
        this.grupoPaciente = grupoPaciente;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return idPaciente == paciente.idPaciente && Objects.equals(nomePaciente, paciente.nomePaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaciente, nomePaciente);
    }
}


