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

    // Listar todos los cursos
    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();  // Retorna todos los cursos almacenados
    }

    // Buscar un curso por ID
    @Override
    public Optional<Curso> buscar(Integer id) {
        return cursoRepository.findById(id);  // Devuelve un Optional que puede contener el curso si se encuentra
    }

    // Guardar un nuevo curso
    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);  // Guarda el curso en la base de datos
    }

    // Actualizar un curso existente
    @Override
    public Curso actualizar(Integer id, Curso curso) {
        Optional<Curso> existingCourse = cursoRepository.findById(id);
        if (existingCourse.isPresent()) {
            Curso cursoToUpdate = existingCourse.get();
            cursoToUpdate.setCodigo(curso.getCodigo());
            cursoToUpdate.setNombre(curso.getNombre());
            cursoToUpdate.setCapacidad(curso.getCapacidad());
            cursoToUpdate.setHorario(curso.getHorario());
            cursoToUpdate.setCiclo(curso.getCiclo());
            return cursoRepository.save(cursoToUpdate);  // Guarda el curso actualizado
        }
        return null;  // Si el curso no existe, retornar null o lanzar excepción
    }

    // Eliminar un curso por ID
    @Override
    public void eliminar(Integer id) {
        cursoRepository.deleteById(id);  // Elimina el curso por su ID
    }
}
