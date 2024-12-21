package com.foliaco.proyecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foliaco.proyecciones.entity.LibroEntity;
import com.foliaco.proyecciones.interfaces.LibroResumen;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    

    @Query(value = "SELECT l.titulo AS titulo, l.anioPublicacion AS anioPublicacion, l.genero AS genero, a.nombre AS autor " +
           "FROM Libro l LEFT JOIN l.autor a " +
           "WHERE l.id = :id")
    LibroResumen buscarResumenDeLibroPorId(Long id);


}
