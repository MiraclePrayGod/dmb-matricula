package com.example.dmbmatriculaservice.dato;

public class CursoDTO {
    private Integer id;  // ID del curso
    private String nombre;  // Nombre del curso
    private Integer capacidad;  // Capacidad máxima de estudiantes en el curso
    private String ciclo;  // Ciclo en el que se dicta el curso

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}
