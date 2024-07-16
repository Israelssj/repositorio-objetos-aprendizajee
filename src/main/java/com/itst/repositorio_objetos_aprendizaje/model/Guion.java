package com.itst.repositorio_objetos_aprendizaje.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "guion")
public class Guion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuion;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "fechaCreacion", nullable = false)
    private String fechaCreacion;

    @Column(name = "materia", length = 50)
    private String materia;

    @Column(name = "nombreDocente", length = 100)
    private String nombreDocente;

    @Column(name = "nombreMateria", length = 100)
    private String nombreMateria;

    @Column(name = "nombreTema", length = 100)
    private String nombreTema;

    @Column(name = "nombreSubtema", length = 100)
    private String nombreSubtema;

    @Column(name = "semestre", length = 20)
    private String semestre;

    @Column(name = "ObjetoAprendizaje", columnDefinition = "TEXT")
    private String objetoAprendizaje;

    @OneToOne(mappedBy = "guion", cascade = CascadeType.ALL)
    private ObjetoAprendizaje objetoAprendizajeRelacionado;

    @OneToMany(mappedBy = "guion", cascade = CascadeType.ALL)
    private List<PresentacionCurso> presentacionesCurso;

    @OneToMany(mappedBy = "guion", cascade = CascadeType.ALL)
    private List<Cuestionario> cuestionarios;

    @OneToMany(mappedBy = "guion", cascade = CascadeType.ALL)
    private List<VideoInteractivo> videosInteractivos;

    @OneToMany(mappedBy = "guion", cascade = CascadeType.ALL)
    private List<EleccionMultiple> eleccionesMultiples;

    @OneToMany(mappedBy = "guion", cascade = CascadeType.ALL)
    private List<ArrastrarPalabras> arrastrarPalabras;

    @OneToMany(mappedBy = "guion", cascade = CascadeType.ALL)
    private List<Crucigrama> crucigramas;

    // Constructores

    public Guion() {
        // Constructor vacío necesario para JPA
    }

    public Guion(String titulo, String descripcion, String fechaCreacion, String materia, String nombreDocente,
                 String nombreMateria, String nombreTema, String nombreSubtema, String semestre, String objetoAprendizaje) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.materia = materia;
        this.nombreDocente = nombreDocente;
        this.nombreMateria = nombreMateria;
        this.nombreTema = nombreTema;
        this.nombreSubtema = nombreSubtema;
        this.semestre = semestre;
        this.objetoAprendizaje = objetoAprendizaje;
    }

    // Getters y Setters

    public Integer getIdGuion() {
        return idGuion;
    }

    public void setIdGuion(Integer idGuion) {
        this.idGuion = idGuion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public String getNombreSubtema() {
        return nombreSubtema;
    }

    public void setNombreSubtema(String nombreSubtema) {
        this.nombreSubtema = nombreSubtema;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getObjetoAprendizaje() {
        return objetoAprendizaje;
    }

    public void setObjetoAprendizaje(String objetoAprendizaje) {
        this.objetoAprendizaje = objetoAprendizaje;
    }

    public ObjetoAprendizaje getObjetoAprendizajeRelacionado() {
        return objetoAprendizajeRelacionado;
    }

    public void setObjetoAprendizajeRelacionado(ObjetoAprendizaje objetoAprendizajeRelacionado) {
        this.objetoAprendizajeRelacionado = objetoAprendizajeRelacionado;
    }

    public List<PresentacionCurso> getPresentacionesCurso() {
        return presentacionesCurso;
    }

    public void setPresentacionesCurso(List<PresentacionCurso> presentacionesCurso) {
        this.presentacionesCurso = presentacionesCurso;
    }

    public List<Cuestionario> getCuestionarios() {
        return cuestionarios;
    }

    public void setCuestionarios(List<Cuestionario> cuestionarios) {
        this.cuestionarios = cuestionarios;
    }

    public List<VideoInteractivo> getVideosInteractivos() {
        return videosInteractivos;
    }

    public void setVideosInteractivos(List<VideoInteractivo> videosInteractivos) {
        this.videosInteractivos = videosInteractivos;
    }

    public List<EleccionMultiple> getEleccionesMultiples() {
        return eleccionesMultiples;
    }

    public void setEleccionesMultiples(List<EleccionMultiple> eleccionesMultiples) {
        this.eleccionesMultiples = eleccionesMultiples;
    }

    public List<ArrastrarPalabras> getArrastrarPalabras() {
        return arrastrarPalabras;
    }

    public void setArrastrarPalabras(List<ArrastrarPalabras> arrastrarPalabras) {
        this.arrastrarPalabras = arrastrarPalabras;
    }

    public List<Crucigrama> getCrucigramas() {
        return crucigramas;
    }

    public void setCrucigramas(List<Crucigrama> crucigramas) {
        this.crucigramas = crucigramas;
    }
}
