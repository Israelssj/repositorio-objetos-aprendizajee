package com.itst.repositorio_objetos_aprendizaje.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "guion")
public class Guion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGuion")
    private int idGuion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    @Column(name = "materia")
    private String materia;

    @Column(name = "nombreDocente")
    private String nombreDocente;

    @Column(name = "nombreMateria")
    private String nombreMateria;

    @Column(name = "nombreTema")
    private String nombreTema;

    @Column(name = "nombreSubtema")
    private String nombreSubtema;

    @Column(name = "semestre")
    private String semestre;

    @Column(name = "ObjetoAprendizaje")
    private String objetoAprendizaje;

    public int getIdGuion() {
        return idGuion;
    }

    public void setIdGuion(int idGuion) {
        this.idGuion = idGuion;
    }

    public String getObjetoAprendizaje() {
        return objetoAprendizaje;
    }

    public void setObjetoAprendizaje(String objetoAprendizaje) {
        this.objetoAprendizaje = objetoAprendizaje;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getNombreSubtema() {
        return nombreSubtema;
    }

    public void setNombreSubtema(String nombreSubtema) {
        this.nombreSubtema = nombreSubtema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
