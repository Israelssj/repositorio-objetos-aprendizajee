package com.itst.repositorio_objetos_aprendizaje.controller;

import com.itst.repositorio_objetos_aprendizaje.model.Usuario;
import com.itst.repositorio_objetos_aprendizaje.model.Descarga;
import com.itst.repositorio_objetos_aprendizaje.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        return usuarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Usuario newUsuario, UriComponentsBuilder ucb) {
        Usuario savedUsuario = usuarioRepository.save(newUsuario);
        URI uri = ucb.path("/usuario/{idUsuario}").buildAndExpand(savedUsuario.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Void> update(@PathVariable Integer idUsuario, @RequestBody Usuario updatedUsuario) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(idUsuario);
        if (existingUsuario.isPresent()) {
            updatedUsuario.setIdUsuario(existingUsuario.get().getIdUsuario());
            usuarioRepository.save(updatedUsuario);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable Integer idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/descargas/{idUsuario}")
    public ResponseEntity<Iterable<Descarga>> getDescargasByUsuario(@PathVariable Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get().getDescargas());
        }
        return ResponseEntity.notFound().build();
    }
}
