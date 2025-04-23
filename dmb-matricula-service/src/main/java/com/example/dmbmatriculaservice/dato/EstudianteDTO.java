package com.example.dmbmatriculaservice.dato;

public class EstudianteDTO {
    private Integer id;  // ID del estudiante
    private String nombre;  // Nombre del estudiante
    private String estado;  // Estado del estudiante (activo, inactivo)
    private String carrera;  // Carrera del estudiante
    private String cicloActual;  // Ciclo actual del estudiante

    // Constructor con parámetros
    public EstudianteDTO(Integer id, String nombre, String estado, String carrera, String cicloActual) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.carrera = carrera;
        this.cicloActual = cicloActual;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(String cicloActual) {
        this.cicloActual = cicloActual;
    }
}
