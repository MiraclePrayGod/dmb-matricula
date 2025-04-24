package com.example.dmbmatriculaservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
@Data
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String course;

}
