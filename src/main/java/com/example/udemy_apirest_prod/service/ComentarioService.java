package com.example.udemy_apirest_prod.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.udemy_apirest_prod.entity.Comentario;
import com.example.udemy_apirest_prod.repository.ComentarioRepository;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    public void deleteById(Integer id) {
        comentarioRepository.deleteById(id);
    }
}
