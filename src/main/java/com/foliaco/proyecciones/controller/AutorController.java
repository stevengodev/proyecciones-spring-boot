package com.foliaco.proyecciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Tuple;

import com.foliaco.proyecciones.dto.AutorDto;
import com.foliaco.proyecciones.interfaces.AutorBiografiaCompleta;
import com.foliaco.proyecciones.interfaces.AutorResumen;
import com.foliaco.proyecciones.repository.AutorRepository;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(@Autowired AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping("/resumen")
    public ResponseEntity<List<AutorResumen>> listarResumenDeAutores() {
        List<AutorResumen> autoresResumen = autorRepository.listarResumenDeAutores();
        return ResponseEntity.ok(autoresResumen);
    }

    @GetMapping("/resumen/{id}")
    public ResponseEntity<AutorResumen> buscarResumenDeAutorPorId(@PathVariable Long id) { 
        AutorResumen autorResumen = autorRepository.buscarResumenDeAutorPorId(id);
        return ResponseEntity.ok(autorResumen);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarBiografiaDeAutorPorId(@PathVariable Long id) {

        Tuple autor = autorRepository.buscarBiografiaDeAutorPorId(id);
        String nombre = (String) autor.get(0);
        String apellido = (String) autor.get(1);
        String nacionalidad = (String) autor.get(2);
        String sexo = (String) autor.get(3);

        AutorDto autorDto = new AutorDto(nombre, apellido, nacionalidad, sexo);

        return ResponseEntity.ok(autorDto);

    }

    @GetMapping("/autor-dto/{id}")
    public ResponseEntity<AutorDto> getAutorDtoConQueryNativa(@PathVariable Long id) {
        AutorDto autorDto = autorRepository.getAutorDtoConQueryNativa(id);
        return ResponseEntity.ok(autorDto);
    }


    @GetMapping("/biografia-completa/{id}")
    public ResponseEntity<AutorBiografiaCompleta> getAutorBiografiaCompleta(@PathVariable Long id) {
    
        AutorBiografiaCompleta autorBiografiaCompleta = autorRepository.getBiografiaCompletaById(id);
        return ResponseEntity.ok(autorBiografiaCompleta);

    }
}
