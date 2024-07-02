package com.itst.repositorio_objetos_aprendizaje.controller;

import com.itst.repositorio_objetos_aprendizaje.model.Guion;
import com.itst.repositorio_objetos_aprendizaje.service.GuionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guiones")
public class GuionController {
    @Autowired
    private GuionService guionService;

    @GetMapping
    public List<Guion> getAllGuiones() {
        return guionService.getAllGuiones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guion> getGuionById(@PathVariable int id) {
        Guion guion = guionService.getGuionById(id);
        if (guion != null) {
            return ResponseEntity.ok(guion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Guion createGuion(@RequestBody Guion guion) {
        return guionService.saveGuion(guion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuion(@PathVariable int id) {
        guionService.deleteGuion(id);
        return ResponseEntity.noContent().build();
    }
}
