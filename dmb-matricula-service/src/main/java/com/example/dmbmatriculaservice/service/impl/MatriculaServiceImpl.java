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


    private final MatriculaRepository matriculaRepository;
    private final EstudianteFeign estudianteFeign;
    private final CursoFeign cursoFeign;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                EstudianteFeign estudianteFeign,
                                CursoFeign cursoFeign) {
        this.matriculaRepository = matriculaRepository;
        this.estudianteFeign = estudianteFeign;
        this.cursoFeign = cursoFeign;
    }
    // Listar todas las matrículas
    @Override
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    // Buscar una matrícula por ID
    @Override
    public Optional<Matricula> buscar(Integer id) {
        return matriculaRepository.findById(id);
    }

    // Guardar una nueva matrícula
    @Override
    public Matricula guardar(Matricula matricula) {
        // Verificar que el estudiante esté activo
        boolean estudianteActivo = verificarEstudianteActivo(matricula.getEstudiante().getId());
        if (!estudianteActivo) {
            throw new RuntimeException("El estudiante no está activo");
        }
        // Verificar la capacidad del curso
        boolean capacidadDisponible = verificarCapacidadCurso(matricula.getCurso().getId());
        if (!capacidadDisponible) {
            throw new RuntimeException("El curso no tiene capacidad disponible");
        }

        // Guardar la nueva matrícula
        return matriculaRepository.save(matricula);
    }

    // Actualizar una matrícula existente
    @Override
    public Matricula actualizar(Integer id, Matricula matricula) {
        Optional<Matricula> existingMatricula = matriculaRepository.findById(id);
        if (existingMatricula.isPresent()) {
            Matricula matriculaActualizada = existingMatricula.get();
            matriculaActualizada.setEstudiante(matricula.getEstudiante());
            matriculaActualizada.setCurso(matricula.getCurso());
            matriculaActualizada.setCiclo(matricula.getCiclo());
            matriculaActualizada.setFechaMatricula(matricula.getFechaMatricula());
            return matriculaRepository.save(matriculaActualizada);
        } else {
            throw new RuntimeException("Matrícula no encontrada");
        }
    }

    // Eliminar una matrícula por ID
    @Override
    public void eliminar(Integer id) {
        matriculaRepository.deleteById(id);
    }

    // Verificar si el estudiante está activo
    private boolean verificarEstudianteActivo(Integer estudianteId) {
        EstudianteDTO estudiante = estudianteFeign.obtenerEstudiantePorId(estudianteId);
        return "activo".equals(estudiante.getEstado());  // Verificar que el estado del estudiante sea "activo"
    }

    // Verificar si el curso tiene capacidad disponible
    private boolean verificarCapacidadCurso(Integer cursoId) {
        return cursoFeign.verificarCapacidadCurso(cursoId);  // Verificar la capacidad del curso mediante Feign
    }
}
