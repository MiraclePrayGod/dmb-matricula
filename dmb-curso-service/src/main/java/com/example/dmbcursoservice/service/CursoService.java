package com.example.dmbcursoservice.service;

import com.example.dmbcursoservice.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    Optional<Curso> buscar(Integer id);
    Curso guardar (Curso curso);
    Curso actualizar (Integer id,Curso curso);
    void eliminar (Integer id);

}
