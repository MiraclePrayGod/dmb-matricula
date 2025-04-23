package com.example.dmbmatriculaservice.dato;

import java.time.LocalDate;

public class MatriculaDTO {
    private Integer estudianteId;  // ID del estudiante
    private Integer cursoId;  // ID del curso
    private String ciclo;  // Ciclo en el que se realiza la matrícula (ej. "2025-1")
    private LocalDate fechaMatricula;  // Fecha en que se realizó la matrícula

    // Constructor con parámetros
    public MatriculaDTO(Integer estudianteId, Integer cursoId, String ciclo, LocalDate fechaMatricula) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.ciclo = ciclo;
        this.fechaMatricula = fechaMatricula;
    }

    // Getters y Setters
    public Integer getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Integer estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
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
