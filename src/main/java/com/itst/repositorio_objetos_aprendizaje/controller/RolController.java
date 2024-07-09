package com.itst.repositorio_objetos_aprendizaje.controller;

import com.itst.repositorio_objetos_aprendizaje.model.Rol;
import com.itst.repositorio_objetos_aprendizaje.model.Usuario;
import com.itst.repositorio_objetos_aprendizaje.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public ResponseEntity<Iterable<Rol>> findAll() {
        return ResponseEntity.ok(rolRepository.findAll());
    }

    @GetMapping("/{idRol}")
    public ResponseEntity<Rol> findById(@PathVariable Integer idRol) {
        Optional<Rol> rolOptional = rolRepository.findById(idRol);
        return rolOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Rol newRol, UriComponentsBuilder ucb) {
        Rol savedRol = rolRepository.save(newRol);
        URI uri = ucb.path("/rol/{idRol}").buildAndExpand(savedRol.getIdRol()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idRol}")
    public ResponseEntity<Void> update(@PathVariable Integer idRol, @RequestBody Rol updatedRol) {
        Optional<Rol> existingRol = rolRepository.findById(idRol);
        if (existingRol.isPresent()) {
            updatedRol.setIdRol(existingRol.get().getIdRol());
            rolRepository.save(updatedRol);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idRol}")
    public ResponseEntity<Void> delete(@PathVariable Integer idRol) {
        if (rolRepository.existsById(idRol)) {
            rolRepository.deleteById(idRol);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{idRol}")
    public ResponseEntity<Iterable<Usuario>> getUsuariosByRol(@PathVariable Integer idRol) {
        Optional<Rol> rolOptional = rolRepository.findById(idRol);
        if (rolOptional.isPresent()) {
            return ResponseEntity.ok(rolOptional.get().getUsuarios());
        }
        return ResponseEntity.notFound().build();
    }
}
