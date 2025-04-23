package com.example.dmbstudentservice.service;

import com.example.dmbstudentservice.entity.Estudiante;

import java.util.List;
import java.util.Optional;


public interface EstudianteService {
    List<Estudiante> listar();
    Optional<Estudiante> buscar(Integer id);
    Estudiante guardar (Estudiante estudiante);
    Estudiante actualizar (Integer id,Estudiante estudiante);
    void eliminar (Integer id);
}
