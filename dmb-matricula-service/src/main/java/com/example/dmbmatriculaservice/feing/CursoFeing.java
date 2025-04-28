package com.example.dmbmatriculaservice.feing;

import com.example.dmbmatriculaservice.dto.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dmb-curso-service", path = "/cursos")
public interface CursoFeing {
        @GetMapping("/{id}")
        ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id);
    }
