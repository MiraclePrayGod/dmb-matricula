package com.example.dmbcursoservice.controller;

import com.example.dmbcursoservice.entity.Curso;
import com.example.dmbcursoservice.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    // Obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listar();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();  // Retorna 204 No Content si no hay cursos
        }
        return ResponseEntity.ok(cursos);  // Retorna 200 OK con los cursos
    }

    // Obtener un curso por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.buscar(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());  // Retorna 200 OK si se encuentra el curso
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Retorna 404 Not Found si no se encuentra
    }

    // Crear un nuevo curso
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.guardar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);  // Retorna 201 Created
    }

    // Actualizar un curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.actualizar(id, curso);
        if (cursoActualizado != null) {
            return ResponseEntity.ok(cursoActualizado);  // Retorna 200 OK con el curso actualizado
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Retorna 404 Not Found si no se encuentra el curso
    }

    // Eliminar un curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.buscar(id);
        if (curso.isPresent()) {
            cursoService.eliminar(id);  // Elimina el curso
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // Retorna 204 No Content si se elimina correctamente
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Retorna 404 Not Found si no se encuentra el curso
    }
}

