package com.itst.repositorio_objetos_aprendizaje.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "descarga")
public class Descarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDescarga")
    private Long idDescarga;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idObjetoAprendizaje")
    private ObjetoAprendizaje objetoAprendizaje;

    // Constructores
    public Descarga() {
        // Constructor vacío necesario para JPA
    }

    public Descarga(LocalDate fecha, Usuario usuario, ObjetoAprendizaje objetoAprendizaje) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.objetoAprendizaje = objetoAprendizaje;
    }

    // Getters y Setters
    public Long getIdDescarga() {
        return idDescarga;
    }

    public void setIdDescarga(Long idDescarga) {
        this.idDescarga = idDescarga;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ObjetoAprendizaje getObjetoAprendizaje() {
        return objetoAprendizaje;
    }

    public void setObjetoAprendizaje(ObjetoAprendizaje objetoAprendizaje) {
        this.objetoAprendizaje = objetoAprendizaje;
    }

    // Método toString
    @Override
    public String toString() {
        return "Descarga{" +
                "idDescarga=" + idDescarga +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                ", objetoAprendizaje=" + objetoAprendizaje +
                '}';
    }
}
