package com.example.udemy_apirest_prod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación explícita con Usuario
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    // Campo adicional para relación con Candidato (si aplica)
    @Column(name = "candidatos_id")
    private Integer candidatosId;

    @Column(name = "fecha_comentario")
    private LocalDateTime fechaComentario;

    @Column(name = "texto_comentario", columnDefinition = "LONGTEXT")
    private String textoComentario;

    // Constructor vacío
    public Comentario() {}

    // Getters y Setters que se pueden generar automáticamente con Lombok para este caso no lo hice asi
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCandidatosId() {
        return candidatosId;
    }

    public void setCandidatosId(Integer candidatosId) {
        this.candidatosId = candidatosId;
    }

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }
}
