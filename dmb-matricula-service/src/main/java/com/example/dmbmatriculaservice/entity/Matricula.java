package com.example.dmbmatriculaservice.entity;

import jakarta.persistence.*;

import java.awt.*;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    private Estudiante estudiante;  // Relación con la entidad Estudiante

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;  // Relación con la entidad Curso

    private String ciclo;  // Ciclo en el que el estudiante se matricula (ej. "2025-1")
    private LocalDate fechaMatricula;  // Fecha en que se realiza la matrícula

    // Constructor vacío
    public Matricula() {}

    // Constructor con parámetros
    public Matricula(Estudiante estudiante, Curso curso, String ciclo, LocalDate fechaMatricula) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.ciclo = ciclo;
        this.fechaMatricula = fechaMatricula;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

}
