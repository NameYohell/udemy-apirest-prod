package com.example.udemy_apirest_prod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.udemy_apirest_prod.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
