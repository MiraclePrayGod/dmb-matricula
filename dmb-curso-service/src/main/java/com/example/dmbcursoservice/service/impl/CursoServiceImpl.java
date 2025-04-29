package com.example.dmbcursoservice.service.impl;

import com.example.dmbcursoservice.entity.Curso;
import com.example.dmbcursoservice.repository.CursoRepository;
import com.example.dmbcursoservice.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> buscar(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso guardar(Curso curso) {
        if (curso.getId() != null && cursoRepository.existsById(curso.getId()) ) {
            throw new IllegalArgumentException("El código del curso ya está registrado");
        }
        return cursoRepository.save(curso);
    }


    @Override
    public Curso actualizar(Integer id, Curso curso) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado");
        }
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    @Override
    public void eliminar(Integer id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado");
        }
        cursoRepository.deleteById(id);
    }
}
