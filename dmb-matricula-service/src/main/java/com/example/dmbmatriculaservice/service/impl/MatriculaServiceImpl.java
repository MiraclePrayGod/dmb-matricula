package com.example.dmbmatriculaservice.service.impl;
import com.example.dmbmatriculaservice.dto.CursoDto;
import com.example.dmbmatriculaservice.dto.Estudiante;
import com.example.dmbmatriculaservice.entity.Matricula;
import com.example.dmbmatriculaservice.entity.MatriculaDetalle;
import com.example.dmbmatriculaservice.feing.CursoFeing;
import com.example.dmbmatriculaservice.feing.EstudianteFeing;
import com.example.dmbmatriculaservice.repository.MatriculaRepository;
import com.example.dmbmatriculaservice.service.MatriculaService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @CircuitBreaker(name = "matriculaListarPorIdCB", fallbackMethod = "FallBackMethodListar")
    public List<Matricula> listar() {
        List<Matricula> matriculas = matriculaRepository.findAll();

        for (Matricula matricula : matriculas) {
            Estudiante estudiante = estudianteFeing.obtenerPorId(matricula.getEstudianteId()).getBody();
            matricula.setEstudiante(estudiante);

            for (MatriculaDetalle detalle : matricula.getDetalles()) {
                CursoDto cursoDto = cursoFeing.obtenerPorId(detalle.getCursoId()).getBody();
                detalle.setCursoDto(cursoDto);
            }
        }
        return matriculas;
    }
    public List<Matricula> FallBackMethodListar(Throwable t) {
        System.err.println("🚨 Fallback listarMatriculas activado: " + t.getMessage());
        // Retornamos lista vacía o con marcador
        return new ArrayList<>();
    }

    @Override
    @CircuitBreaker(name = "matriculaListarPorIdCB", fallbackMethod = "FallBackMethodBuscar")
    public Optional<Matricula> buscar(Integer id) {
         Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);

        optionalMatricula.ifPresent(matricula -> {
            Estudiante estudiante = estudianteFeing.obtenerPorId(matricula.getEstudianteId()).getBody();
            matricula.setEstudiante(estudiante);

            for (MatriculaDetalle detalle : matricula.getDetalles()) {
                CursoDto cursoDto = cursoFeing.obtenerPorId(detalle.getCursoId()).getBody();
                detalle.setCursoDto(cursoDto);
            }
        });

        return optionalMatricula;
    }

    public Optional<Matricula> FallBackMethodBuscar(Integer id, Throwable t) {
        System.err.println("🚨 Fallback buscarMatricula activado para id " + id + ": " + t.getMessage());
        return Optional.empty();
    }

    @Override
    @CircuitBreaker(name = "matriculaListarPorIdCB", fallbackMethod = "FallBackMethodGuardar")
    public Matricula guardar(Matricula matricula) {
        Estudiante estudiante = estudianteFeing.obtenerPorId(matricula.getEstudianteId()).getBody();
        if (estudiante == null || !"activo".equals(estudiante.getEstado())) {
            throw new RuntimeException("Estudiante no válido o inactivo");
        }

        matricula.setCiclo(estudiante.getCicloActual());
        matricula.setFecha(LocalDate.now());

        for (MatriculaDetalle detalle : matricula.getDetalles()) {
            CursoDto cursoDto = cursoFeing.obtenerPorId(detalle.getCursoId()).getBody();
            if (cursoDto == null || cursoDto.getCapacidad() <= 0) {
                throw new RuntimeException("Curso no disponible o sin capacidad");
            }
            cursoDto.setCapacidad(cursoDto.getCapacidad() - 1);
            cursoFeing.actualizarCurso(cursoDto.getId(),cursoDto);
            detalle.setCursoDto(cursoDto);
        }

        return matriculaRepository.save(matricula);

}

    public Matricula FallBackMethodGuardar(Matricula matricula,Throwable t) {
        System.err.println("🚨 Fallback guardarMatricula activado para id " + t.getMessage());
        matricula.setId(-1);
        return matricula;
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