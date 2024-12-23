package com.foliaco.proyecciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foliaco.proyecciones.entity.LibroEntity;
import com.foliaco.proyecciones.interfaces.LibroResumen;

import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    

    @Query(value = "SELECT l.titulo AS titulo, l.anioPublicacion AS anioPublicacion, l.genero AS genero, a.nombre AS autor " +
           "FROM LibroEntity l LEFT JOIN l.autor a " +
           "WHERE l.id = :id")
    LibroResumen buscarResumenDeLibroPorId(@Param("id") Long id);

    /**
    proyeccion basada en clases, especificamente en dto
    En lugar de obtener los campos podriamos devolver directamente el dto de la siguiente manera, sin embargo,
    en este caso se opto por devolver un Tuple para obtener los campos de una forma mas facil
    @Query(value = "SELECT new com.foliaco.proyecciones.dto.LibroResumenDto(l.titulo, l.anioPublicacion, l.genero, a.nombre) " +
    "FROM LibroEntity l LEFT JOIN l.autor a " +
    "WHERE l.id = :id")
    */

    @Query(value = "SELECT l.titulo AS titulo, l.anioPublicacion AS anioPublicacion, l.genero AS genero, a.nombre AS autor " +
           "FROM LibroEntity l LEFT JOIN l.autor a " +
           "WHERE l.id = :id")
    Tuple buscarLibroDtoPorId(@Param("id") Long id);


    // proyeccion dinamica
    @Query(value = "SELECT l.titulo AS titulo, l.anioPublicacion AS anioPublicacion, l.genero AS genero, a.nombre AS autor " +
    "FROM LibroEntity l LEFT JOIN l.autor a " +
    "WHERE l.id = :id")
    <T> T getResumenDeLibroPorId(@Param("id") Long id, Class<T> type);

}
