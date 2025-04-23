package com.example.dmbmatriculaservice.service.impl;

import com.example.dmbmatriculaservice.dato.EstudianteDTO;
import com.example.dmbmatriculaservice.dato.MatriculaDTO;
import com.example.dmbmatriculaservice.entity.Matricula;
import com.example.dmbmatriculaservice.feing.CursoFeign;
import com.example.dmbmatriculaservice.feing.EstudianteFeign;
import com.example.dmbmatriculaservice.repository.MatriculaRepository;
import com.example.dmbmatriculaservice.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {


    @Override
    public List<Matricula> listar() {
        return List.of();
    }

    @Override
    public Optional<Matricula> buscar(Integer id) {
        return Optional.empty();
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return null;
    }

    @Override
    public Matricula actualizar(Integer id, Matricula matricula) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }
}
