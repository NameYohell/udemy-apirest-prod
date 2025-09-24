package com.example.udemy_apirest_prod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_usuario", length = 30)
    private String nombreUsuario;

    @Column(name = "email_usuario", length = 150)
    private String emailUsuario;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "idioma", length = 30)
    private String idioma;

    @Column(name = "zona_horaria", length = 30)
    private String zonaHoraria;
}