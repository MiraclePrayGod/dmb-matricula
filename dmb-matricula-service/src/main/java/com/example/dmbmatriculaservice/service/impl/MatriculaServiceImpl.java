package com.example.dmbmatriculaservice.service.impl;
import com.example.dmbmatriculaservice.dto.Curso;
import com.example.dmbmatriculaservice.dto.Estudiante;
import com.example.dmbmatriculaservice.entity.Matricula;
import com.example.dmbmatriculaservice.entity.MatriculaDetalle;
import com.example.dmbmatriculaservice.feing.CursoFeing;
import com.example.dmbmatriculaservice.feing.EstudianteFeing;
import com.example.dmbmatriculaservice.repository.MatriculaRepository;
import com.example.dmbmatriculaservice.service.MatriculaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository; // Cliente Feign para interactuar con el servicio de cursos
    @Autowired
    private CursoFeing cursoFeing;
    @Autowired
    private EstudianteFeing estudianteFeing;

    @Override
    public List<Matricula> listar() {
        List<Matricula> matriculas = matriculaRepository.findAll();

        for (Matricula matricula : matriculas) {
            Estudiante estudiante = estudianteFeing.obtenerPorId(matricula.getEstudianteId()).getBody();
            matricula.setEstudiante(estudiante);

            for (MatriculaDetalle detalle : matricula.getDetalles()) {
                Curso curso = cursoFeing.obtenerPorId(detalle.getCursoId()).getBody();
                detalle.setCurso(curso);
            }
        }
        return matriculas;
    }

    @Override
    public Optional<Matricula> buscar(Integer id) {
         Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);

        optionalMatricula.ifPresent(matricula -> {
            Estudiante estudiante = estudianteFeing.obtenerPorId(matricula.getEstudianteId()).getBody();
            matricula.setEstudiante(estudiante);

            for (MatriculaDetalle detalle : matricula.getDetalles()) {
                Curso curso = cursoFeing.obtenerPorId(detalle.getCursoId()).getBody();
                detalle.setCurso(curso);
            }
        });

        return optionalMatricula;
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        Estudiante estudiante = estudianteFeing.obtenerPorId(matricula.getEstudianteId()).getBody();
        if (estudiante == null || !"Activo".equals(estudiante.getEstado())) {
            throw new RuntimeException("Estudiante no válido o inactivo");
        }

        matricula.setCiclo(estudiante.getCiclo());
        matricula.setFecha(LocalDate.now());

        for (MatriculaDetalle detalle : matricula.getDetalles()) {
            Curso curso = cursoFeing.obtenerPorId(detalle.getCursoId()).getBody();
            if (curso == null || curso.getCapacidad() <= 0) {
                throw new RuntimeException("Curso no disponible o sin capacidad");
            }
            detalle.setCurso(curso);
        }

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