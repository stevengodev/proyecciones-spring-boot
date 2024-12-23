package com.foliaco.proyecciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foliaco.proyecciones.interfaces.LibroResumen;
import com.foliaco.proyecciones.repository.LibroRepository;

@RestController
@RequestMapping("api/libros")
public class LibroController {
    
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/resumen/{id}")
    public ResponseEntity<LibroResumen> listarResumenDeLibrosConProyeccionDinamica(@PathVariable Long id) {
        LibroResumen libroResumen = libroRepository.getResumenDeLibroPorId(id, LibroResumen.class);
        return ResponseEntity.ok(libroResumen);
    }

}
