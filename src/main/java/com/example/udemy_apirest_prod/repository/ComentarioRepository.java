package com.example.udemy_apirest_prod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.udemy_apirest_prod.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {}
