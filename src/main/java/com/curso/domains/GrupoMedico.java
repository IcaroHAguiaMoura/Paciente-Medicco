package com.curso.domains;

import com.curso.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Objects;

@Entity
@Table(name="grupomedico")
public class GrupoMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupomedico")
    private long id;

    @NotNull @NotBlank
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="status")
    private Status status;

    public GrupoMedico(){
        this.status = Status.ATIVO;

    }

    public GrupoMedico(long id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        GrupoMedico that = (GrupoMedico) o;
        return id == that.id && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
