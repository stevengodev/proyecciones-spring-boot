package com.foliaco.proyecciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foliaco.proyecciones.entity.AutorEntity;
import com.foliaco.proyecciones.interfaces.AutorBiografiaCompleta;
import com.foliaco.proyecciones.interfaces.AutorResumen;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    
    @Query(value = "SELECT a.nombre AS nombre, a.apellido AS apellido, COUNT(l) AS cantidadLibros " +
           "FROM Autor a LEFT JOIN a.libros l " +
           "GROUP BY a.nombre")
    List<AutorResumen> listarResumenDeAutores();

    @Query(value = "SELECT a.nombre AS nombre, a.apellido AS apellido, COUNT(l) AS cantidadLibros " +
           "FROM Autor a LEFT JOIN a.libros l " +
           "WHERE a.id = :id " +
           "GROUP BY a.nombre")
    AutorResumen buscarResumenDeAutorPorId(@Param("id") Long id);

    @Query(value = "SELECT a.nombre AS nombre, a.apellido AS apellido, a.nacionalidad AS nacionalidad, a.sexo AS sexo, COUNT(l) AS cantidadLibros " +
           "FROM Autor a LEFT JOIN a.libros l " +
           "WHERE a.id = :id " +
           "GROUP BY a.nombre")
    AutorBiografiaCompleta buscarBiografiaDeAutorPorId(@Param("id") Long id);

}
