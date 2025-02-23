package com.curso.domains;

import com.curso.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name="grupopaciente")
public class GrupoPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_grupopaciente")
    private int id;

    @NotNull@NotBlank
    @JoinColumn(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private Status status;


    public GrupoPaciente(){
        this.status=Status.ATIVO;
    }

    public GrupoPaciente(int id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        GrupoPaciente that = (GrupoPaciente) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
