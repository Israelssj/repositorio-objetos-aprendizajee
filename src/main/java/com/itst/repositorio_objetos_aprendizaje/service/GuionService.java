package com.itst.repositorio_objetos_aprendizaje.service;

import com.itst.repositorio_objetos_aprendizaje.model.Guion;
import com.itst.repositorio_objetos_aprendizaje.repository.GuionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuionService {
    @Autowired
    private GuionRepository guionRepository;

    public List<Guion> getAllGuiones() {
        return guionRepository.findAll();
    }

    public Guion getGuionById(int id) {
        return guionRepository.findById(id).orElse(null);
    }

    public Guion saveGuion(Guion guion) {
        return guionRepository.save(guion);
    }

    public void deleteGuion(int id) {
        guionRepository.deleteById(id);
    }
}
