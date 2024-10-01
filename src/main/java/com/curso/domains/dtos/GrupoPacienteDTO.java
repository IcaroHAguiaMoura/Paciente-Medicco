package com.curso.domains.dtos;

import com.curso.domains.GrupoPaciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GrupoPacienteDTO {

    private int id;

    @NotNull(message = "O campo descricao nao pode ser nulo")
    @NotBlank(message = "O campo descricao nao deve estar vazio")
    private  String descricao;
    private int status;

    public GrupoPacienteDTO(){}

    public GrupoPacienteDTO(GrupoPaciente grupoPaciente){
        this.id=grupoPaciente.getId();
        this.descricao = grupoPaciente.getDescricao();
        this.status=grupoPaciente.getStatus().getId();
    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descricao nao pode ser nulo") @NotBlank(message = "O campo descricao nao deve estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao nao pode ser nulo") @NotBlank(message = "O campo descricao nao deve estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
