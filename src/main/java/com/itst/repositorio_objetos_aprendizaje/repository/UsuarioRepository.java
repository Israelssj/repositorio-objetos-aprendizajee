package com.itst.repositorio_objetos_aprendizaje.repository;


import com.itst.repositorio_objetos_aprendizaje.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
