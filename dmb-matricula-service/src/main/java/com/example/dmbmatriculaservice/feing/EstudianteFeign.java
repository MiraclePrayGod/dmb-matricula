package com.example.dmbmatriculaservice.feing;

import com.example.dmbmatriculaservice.dato.EstudianteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cem-student-service", url = "http://dmb-student-service")  // Configura el nombre o URL del servicio de Estudiantes

public interface EstudianteFeign {
    @GetMapping("/api/students/{id}")
    EstudianteDTO obtenerEstudiantePorId(@PathVariable("id") Integer id); // Asegúrate de que este método esté correcto
}
