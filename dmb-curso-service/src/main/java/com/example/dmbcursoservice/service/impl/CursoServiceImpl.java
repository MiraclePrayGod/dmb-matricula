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
    public Curso guardar(Curso matricula) {
        return cursoRepository.save(matricula);
    }

    @Override
    public Curso actualizar(Integer id, Curso curso) {
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    @Override
    public void eliminar(Integer id) {
        cursoRepository.deleteById(id);
    }
}
