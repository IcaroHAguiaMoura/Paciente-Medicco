package com.curso.domains.dtos;

import com.curso.domains.Medico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicoDTO {

    private long idMedico;

    @NotNull(message = "o campo nomeMedico nao pode ser nulo")
    @NotNull(message = "o campo nomeMedico nao pode estar vazio")
    private String nomeMedico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContracao = LocalDate.now();

    @NotNull(message = "O campo salario nao pode ser nulo")
    @Digits(integer = 15,fraction = 3)
    private BigDecimal salario;

    @NotNull(message = "O campo grupo Medico é requerido")
    private long grupoMedico;
    private String descricaoGrupoMedico;

    private int status;

    public MedicoDTO(){}

    public MedicoDTO(Medico medico) {
        this.idMedico = medico.getIdMedico();
        this.nomeMedico = medico.getNomeMedico();
        this.dataContracao = medico.getDataContratacao();
        this.salario = medico.getSalario();
        this.grupoMedico = medico.getGrupoMedico().getId();
        this.descricaoGrupoMedico = medico.getGrupoMedico().getDescricao();
        this.status = medico.getStatus().getId();
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public @NotNull(message = "o campo nomeMedico nao pode ser nulo") @NotNull(message = "o campo nomeMedico nao pode estar vazio") String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(@NotNull(message = "o campo nomeMedico nao pode ser nulo") @NotNull(message = "o campo nomeMedico nao pode estar vazio") String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public LocalDate getDataContracao() {
        return dataContracao;
    }

    public void setDataContracao(LocalDate dataContracao) {
        this.dataContracao = dataContracao;
    }

    public @NotNull(message = "O campo salario nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O campo salario nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal salario) {
        this.salario = salario;
    }

    @NotNull(message = "O campo grupo Medico é requerido")
    public long getGrupoMedico() {
        return grupoMedico;
    }

    public void setGrupoMedico(@NotNull(message = "O campo grupo Medico é requerido") long grupoMedico) {
        this.grupoMedico = grupoMedico;
    }

    public String getDescricaoGrupoMedico() {
        return descricaoGrupoMedico;
    }

    public void setDescricaoGrupoMedico(String descricaoGrupoMedico) {
        this.descricaoGrupoMedico = descricaoGrupoMedico;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
