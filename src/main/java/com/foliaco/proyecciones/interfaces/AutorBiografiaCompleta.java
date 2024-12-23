package com.foliaco.proyecciones.interfaces;

import org.springframework.beans.factory.annotation.Value;

// proyeccion abierta
public interface AutorBiografiaCompleta {
    
    @Value("#{target.nombre} #{target.apellido} #{target.nacionalidad} #{target.sexo} #{target.cantidadLibros}")
    String getBiografia();
    
}
