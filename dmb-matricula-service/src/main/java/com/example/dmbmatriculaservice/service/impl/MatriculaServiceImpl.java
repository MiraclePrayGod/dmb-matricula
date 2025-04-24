package com.example.dmbmatriculaservice.service.impl;
import com.example.dmbmatriculaservice.entity.Matricula;
import com.example.dmbmatriculaservice.repository.MatriculaRepository;
import com.example.dmbmatriculaservice.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {


    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> buscar(Integer id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizar(Integer id, Matricula matricula) {
        matricula.setId(id);
        return matriculaRepository.save(matricula);
    }

    @Override
    public void eliminar(Integer id) {
        matriculaRepository.deleteById(id);
    }
}
