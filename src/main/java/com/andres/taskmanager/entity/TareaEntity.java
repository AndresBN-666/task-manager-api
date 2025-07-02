package com.andres.taskmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarea")
@Data
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    private int estado; // 0 = pendiente, 1 = en progreso, 2 = completada

    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
