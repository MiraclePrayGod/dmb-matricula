package com.example.dmbmatriculaservice.entity;

import jakarta.persistence.*;

import java.awt.*;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
