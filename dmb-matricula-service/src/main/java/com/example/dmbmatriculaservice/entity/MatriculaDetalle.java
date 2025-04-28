package com.example.dmbmatriculaservice.entity;

import com.example.dmbmatriculaservice.dto.Curso;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;

import java.util.List;

@Entity
public class MatriculaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cursoId;

    @Transient
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_Id")

    private Matricula matriculas;

    public MatriculaDetalle() {

    }

    public MatriculaDetalle(Integer id, Integer cursoId) {
        this.id = id;
        this.cursoId = cursoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Matricula getMatriculas() {
        return matriculas;
    }
    public void setMatriculas(Matricula matriculas) {
        this.matriculas = matriculas;
    }

}
