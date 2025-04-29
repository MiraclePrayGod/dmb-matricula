package com.example.dmbmatriculaservice.repository;

import com.example.dmbmatriculaservice.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}

