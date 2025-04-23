package com.example.dmbmatriculaservice.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cem-course-service", url = "http://cem-course-service")  // Configura el nombre o URL del servicio de Cursos

public interface CursoFeign {
    @GetMapping("/api/courses/{id}")
    boolean verificarCapacidadCurso(@PathVariable("id") Integer id);
}
