package com.foliaco.proyecciones.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AutorDto {
    
    private String nombre;

    private String apellido;

    List<LibroDto> libros;

}
