package com.curso.domains.dtos;


import com.curso.domains.GrupoMedico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GrupoMedicoDTO {

    private long id;

    @NotNull(message = "O campo descrição nao pode ser nulo")
    @NotBlank(message = "O campo descrição nao pode estar vazio")
    private String descricao;
    private int status;

    public GrupoMedicoDTO(){}

    public GrupoMedicoDTO(GrupoMedico grupoMedico) {
        this.id = grupoMedico.getId();
        this.descricao = grupoMedico.getDescricao();
        this.status = grupoMedico.getStatus().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descrição nao pode ser nulo") @NotBlank(message = "O campo descrição nao pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição nao pode ser nulo") @NotBlank(message = "O campo descrição nao pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

