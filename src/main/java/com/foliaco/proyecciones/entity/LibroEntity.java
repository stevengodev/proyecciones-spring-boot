package com.foliaco.proyecciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "libros")
@Getter
@Setter
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int anioPublicacion;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private double precio;
    
    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private AutorEntity autor;

    
}
