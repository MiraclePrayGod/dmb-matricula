package com.example.dmbcursoservice.controller;

import com.example.dmbcursoservice.entity.Curso;
import com.example.dmbcursoservice.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Curso> buscar(@PathVariable Integer id) {
        return cursoService.buscar(id);
    }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return cursoService.guardar(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        return cursoService.actualizar(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cursoService.eliminar(id);
    }
}

