package com.example.udemy_apirest_prod.dto;

import java.time.LocalDateTime;

public class ComentarioUsuarioDTO {

    private String nombreUsuario;
    private String emailUsuario;
    private String textoComentario;
    private LocalDateTime fechaComentario;

    public ComentarioUsuarioDTO() {}

    public ComentarioUsuarioDTO(String nombreUsuario, String emailUsuario, String textoComentario, LocalDateTime fechaComentario) {
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.textoComentario = textoComentario;
        this.fechaComentario = fechaComentario;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}
