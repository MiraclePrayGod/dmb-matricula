package com.example.dmbcursoservice.repository;

import com.example.dmbcursoservice.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
