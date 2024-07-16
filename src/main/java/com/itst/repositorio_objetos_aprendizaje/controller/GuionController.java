package com.itst.repositorio_objetos_aprendizaje.controller;

import com.itst.repositorio_objetos_aprendizaje.model.Guion;
import com.itst.repositorio_objetos_aprendizaje.repository.GuionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guiones")
public class GuionController {

    private final GuionRepository guionRepository;

    @Autowired
    public GuionController(GuionRepository guionRepository) {
        this.guionRepository = guionRepository;
    }

    // Obtener todos los guiones
    @GetMapping
    public ResponseEntity<List<Guion>> getAllGuiones() {
        List<Guion> guiones = guionRepository.findAll();
        return new ResponseEntity<>(guiones, HttpStatus.OK);
    }

    // Obtener un guion por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Guion> getGuionById(@PathVariable Integer id) {
        Optional<Guion> guionOptional = guionRepository.findById(id);
        return guionOptional.map(guion -> new ResponseEntity<>(guion, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo guion
    @PostMapping
    public ResponseEntity<Guion> createGuion(@RequestBody Guion guion) {
        Guion nuevoGuion = guionRepository.save(guion);
        return new ResponseEntity<>(nuevoGuion, HttpStatus.CREATED);
    }

    // Actualizar un guion existente
    @PutMapping("/{id}")
    public ResponseEntity<Guion> updateGuion(@PathVariable Integer id, @RequestBody Guion guionActualizado) {
        Optional<Guion> guionOptional = guionRepository.findById(id);
        if (guionOptional.isPresent()) {
            Guion guionExistente = guionOptional.get();
            guionExistente.setTitulo(guionActualizado.getTitulo());
            guionExistente.setDescripcion(guionActualizado.getDescripcion());
            guionExistente.setFechaCreacion(guionActualizado.getFechaCreacion());
            guionExistente.setMateria(guionActualizado.getMateria());
            guionExistente.setNombreDocente(guionActualizado.getNombreDocente());
            guionExistente.setNombreMateria(guionActualizado.getNombreMateria());
            guionExistente.setNombreTema(guionActualizado.getNombreTema());
            guionExistente.setNombreSubtema(guionActualizado.getNombreSubtema());
            guionExistente.setSemestre(guionActualizado.getSemestre());
            guionExistente.setObjetoAprendizaje(guionActualizado.getObjetoAprendizaje());
            guionExistente.setObjetoAprendizajeRelacionado(guionActualizado.getObjetoAprendizajeRelacionado());
            guionExistente.setPresentacionesCurso(guionActualizado.getPresentacionesCurso());
            guionExistente.setCuestionarios(guionActualizado.getCuestionarios());
            guionExistente.setVideosInteractivos(guionActualizado.getVideosInteractivos());
            guionExistente.setEleccionesMultiples(guionActualizado.getEleccionesMultiples());
            guionExistente.setArrastrarPalabras(guionActualizado.getArrastrarPalabras());
            guionExistente.setCrucigramas(guionActualizado.getCrucigramas());

            Guion guionActualizadoDB = guionRepository.save(guionExistente);
            return new ResponseEntity<>(guionActualizadoDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un guion por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuion(@PathVariable Integer id) {
        Optional<Guion> guionOptional = guionRepository.findById(id);
        if (guionOptional.isPresent()) {
            guionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
