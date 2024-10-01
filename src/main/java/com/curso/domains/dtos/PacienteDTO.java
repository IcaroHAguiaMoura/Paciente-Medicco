package com.curso.domains.dtos;

import com.curso.domains.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PacienteDTO {

    public long idPaciente;

    @NotNull(message = "O campo nome do paciente nao pode ser nulo")
    @NotBlank(message = "O campo nome do paciente  nao pode estar vazio")
    private String nomePaciente;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento = LocalDate.now();

    @NotNull(message = "O campo custo internacao nao pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal custoInternacao;

    @NotNull(message = "O campo GrupoPaciente é requerido")
    private int grupoPaciente;
    private String descricaoGrupoPaciente;

    private int status;

    public  PacienteDTO(){ }

    public PacienteDTO(Paciente paciente) {
        this.idPaciente = paciente.getIdPaciente();
        this.nomePaciente = paciente.getNomePaciente();
        this.dataNascimento = paciente.getDataNascimento();
        this.custoInternacao = paciente.getCustoInternacao();
        this.grupoPaciente = paciente.getGrupoPaciente().getId();
        this.descricaoGrupoPaciente = paciente.getGrupoPaciente().getDescricao();
        this.status = paciente.getStatus().getId();
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public @NotNull(message = "O campo nome do paciente nao pode ser nulo") @NotBlank(message = "O campo nome do paciente  nao pode estar vazio") String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(@NotNull(message = "O campo nome do paciente nao pode ser nulo") @NotBlank(message = "O campo nome do paciente  nao pode estar vazio") String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O campo custo internacao nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(@NotNull(message = "O campo custo internacao nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    @NotNull(message = "O campo GrupoPaciente é requerido")
    public int getGrupoPaciente() {
        return grupoPaciente;
    }

    public void setGrupoPaciente(@NotNull(message = "O campo GrupoPaciente é requerido") int grupoPaciente) {
        this.grupoPaciente = grupoPaciente;
    }

    public String getDescricaoGrupoPaciente() {
        return descricaoGrupoPaciente;
    }

    public void setDescricaoGrupoPaciente(String descricaoGrupoPaciente) {
        this.descricaoGrupoPaciente = descricaoGrupoPaciente;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


