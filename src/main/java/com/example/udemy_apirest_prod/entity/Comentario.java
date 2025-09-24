package com.example.udemy_apirest_prod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //si quisiera agregar usuarioID como llave foranea basta con agregar la anotacion @ManyToOne
    @Column(name = "usuarios_id")
    private Integer usuariosId;
    //si quisiera agregar candidato_id como llave foranea basta con agregar la anotacion @ManyToOne
    @Column(name = "candidatos_id")
    private Integer candidatosId;

    @Column(name = "fecha_comentario")
    private LocalDateTime fechaComentario;

    @Column(name = "texto_comentario", columnDefinition = "LONGTEXT")
    private String textoComentario;

    public Comentario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
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