package com.itst.repositorio_objetos_aprendizaje.controller;

import com.itst.repositorio_objetos_aprendizaje.model.Diapositiva;
import com.itst.repositorio_objetos_aprendizaje.repository.DiapositivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diapositivas")
public class DiapositivaController {

    private final DiapositivaRepository diapositivaRepository;

    @Autowired
    public DiapositivaController(DiapositivaRepository diapositivaRepository) {
        this.diapositivaRepository = diapositivaRepository;
    }

    // Obtener todas las diapositivas
    @GetMapping
    public ResponseEntity<List<Diapositiva>> getAllDiapositivas() {
        List<Diapositiva> diapositivas = diapositivaRepository.findAll();
        return new ResponseEntity<>(diapositivas, HttpStatus.OK);
    }

    // Obtener una diapositiva por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Diapositiva> getDiapositivaById(@PathVariable Integer id) {
        Optional<Diapositiva> diapositivaOptional = diapositivaRepository.findById(id);
        return diapositivaOptional.map(diapositiva -> new ResponseEntity<>(diapositiva, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear una nueva diapositiva
    @PostMapping
    public ResponseEntity<Diapositiva> createDiapositiva(@RequestBody Diapositiva diapositiva) {
        Diapositiva nuevaDiapositiva = diapositivaRepository.save(diapositiva);
        return new ResponseEntity<>(nuevaDiapositiva, HttpStatus.CREATED);
    }

    // Actualizar una diapositiva existente
    @PutMapping("/{id}")
    public ResponseEntity<Diapositiva> updateDiapositiva(@PathVariable Integer id, @RequestBody Diapositiva diapositivaActualizada) {
        Optional<Diapositiva> diapositivaOptional = diapositivaRepository.findById(id);
        if (diapositivaOptional.isPresent()) {
            Diapositiva diapositivaExistente = diapositivaOptional.get();
            diapositivaExistente.setDescripcion(diapositivaActualizada.getDescripcion());
            diapositivaExistente.setInteracciones(diapositivaActualizada.getInteracciones());
            diapositivaExistente.setPresentacionCurso(diapositivaActualizada.getPresentacionCurso());

            Diapositiva diapositivaActualizadaDB = diapositivaRepository.save(diapositivaExistente);
            return new ResponseEntity<>(diapositivaActualizadaDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una diapositiva por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiapositiva(@PathVariable Integer id) {
        Optional<Diapositiva> diapositivaOptional = diapositivaRepository.findById(id);
        if (diapositivaOptional.isPresent()) {
            diapositivaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
