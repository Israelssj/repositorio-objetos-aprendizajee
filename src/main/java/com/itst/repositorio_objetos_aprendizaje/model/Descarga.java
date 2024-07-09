package com.itst.repositorio_objetos_aprendizaje.model;

import jakarta.persistence.*;

@Entity
public class Descarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDescarga;

    @Column(nullable = false)
    private String nombreArchivo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    // Getters y Setters
    public Integer getIdDescarga() {
        return idDescarga;
    }

    public void setIdDescarga(Integer idDescarga) {
        this.idDescarga = idDescarga;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
