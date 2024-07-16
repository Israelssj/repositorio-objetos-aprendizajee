package com.itst.repositorio_objetos_aprendizaje.controller;

import com.itst.repositorio_objetos_aprendizaje.model.ElementosArrastrarPalabras;
import com.itst.repositorio_objetos_aprendizaje.repository.ElementosArrastrarPalabrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elementos-arrastrar-palabras")
public class ElementosArrastrarPalabrasController {

    private final ElementosArrastrarPalabrasRepository elementosArrastrarPalabrasRepository;

    @Autowired
    public ElementosArrastrarPalabrasController(ElementosArrastrarPalabrasRepository elementosArrastrarPalabrasRepository) {
        this.elementosArrastrarPalabrasRepository = elementosArrastrarPalabrasRepository;
    }

    // Obtener todos los elementos de arrastrar palabras
    @GetMapping
    public ResponseEntity<List<ElementosArrastrarPalabras>> getAllElementosArrastrarPalabras() {
        List<ElementosArrastrarPalabras> elementosArrastrarPalabrasList = elementosArrastrarPalabrasRepository.findAll();
        return new ResponseEntity<>(elementosArrastrarPalabrasList, HttpStatus.OK);
    }

    // Obtener un elemento de arrastrar palabras por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ElementosArrastrarPalabras> getElementosArrastrarPalabrasById(@PathVariable Integer id) {
        Optional<ElementosArrastrarPalabras> elementosArrastrarPalabrasOptional = elementosArrastrarPalabrasRepository.findById(id);
        return elementosArrastrarPalabrasOptional.map(elementosArrastrarPalabras -> new ResponseEntity<>(elementosArrastrarPalabras, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo elemento de arrastrar palabras
    @PostMapping
    public ResponseEntity<ElementosArrastrarPalabras> createElementosArrastrarPalabras(@RequestBody ElementosArrastrarPalabras elementosArrastrarPalabras) {
        ElementosArrastrarPalabras nuevosElementosArrastrarPalabras = elementosArrastrarPalabrasRepository.save(elementosArrastrarPalabras);
        return new ResponseEntity<>(nuevosElementosArrastrarPalabras, HttpStatus.CREATED);
    }

    // Actualizar un elemento de arrastrar palabras existente
    @PutMapping("/{id}")
    public ResponseEntity<ElementosArrastrarPalabras> updateElementosArrastrarPalabras(@PathVariable Integer id, @RequestBody ElementosArrastrarPalabras elementosArrastrarPalabrasActualizado) {
        Optional<ElementosArrastrarPalabras> elementosArrastrarPalabrasOptional = elementosArrastrarPalabrasRepository.findById(id);
        if (elementosArrastrarPalabrasOptional.isPresent()) {
            ElementosArrastrarPalabras elementosArrastrarPalabrasExistente = elementosArrastrarPalabrasOptional.get();
            elementosArrastrarPalabrasExistente.setPalabras(elementosArrastrarPalabrasActualizado.getPalabras());
            elementosArrastrarPalabrasExistente.setArrastrarPalabras(elementosArrastrarPalabrasActualizado.getArrastrarPalabras());

            ElementosArrastrarPalabras elementosArrastrarPalabrasActualizadoDB = elementosArrastrarPalabrasRepository.save(elementosArrastrarPalabrasExistente);
            return new ResponseEntity<>(elementosArrastrarPalabrasActualizadoDB, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un elemento de arrastrar palabras por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementosArrastrarPalabras(@PathVariable Integer id) {
        Optional<ElementosArrastrarPalabras> elementosArrastrarPalabrasOptional = elementosArrastrarPalabrasRepository.findById(id);
        if (elementosArrastrarPalabrasOptional.isPresent()) {
            elementosArrastrarPalabrasRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
