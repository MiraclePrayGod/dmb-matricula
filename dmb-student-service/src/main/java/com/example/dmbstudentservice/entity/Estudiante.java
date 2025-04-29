package com.example.dmbstudentservice.entity;


import jakarta.persistence.*;

@Entity

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String documento;  // Número de documento, único
    private String nombre;
    private String carrera;
    private String estado;  // Activo o Inactivo
    private Integer cicloActual;

    public Estudiante() {
    }

    public Estudiante(Integer id, String documento, String nombre, String carrera, String estado, Integer cicloActual) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.carrera = carrera;
        this.estado = estado;
        this.cicloActual = cicloActual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCicloActual() {
        return cicloActual;
    }

    public void setCicloActual(Integer cicloActual) {
        this.cicloActual = cicloActual;
    }
}