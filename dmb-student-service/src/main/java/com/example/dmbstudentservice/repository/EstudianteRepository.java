package com.example.dmbstudentservice.repository;

import com.example.dmbstudentservice.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
