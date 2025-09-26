package com.example.udemy_apirest_prod.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.udemy_apirest_prod.dto.ComentarioUsuarioDTO;
import com.example.udemy_apirest_prod.entity.Comentario;
import com.example.udemy_apirest_prod.entity.Usuario;
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
    public List<ComentarioUsuarioDTO> obtenerComentariosConUsuario() {
    List<Comentario> comentarios = comentarioRepository.findAll();
    List<ComentarioUsuarioDTO> dtoList = new ArrayList<>();

    for (Comentario comentario : comentarios) {
        Usuario usuario = comentario.getUsuario();
        ComentarioUsuarioDTO dto = new ComentarioUsuarioDTO(
            usuario.getNombreUsuario(),
            usuario.getEmailUsuario(),
            comentario.getTextoComentario(),
            comentario.getFechaComentario()
        );
        dtoList.add(dto);
    }

    return dtoList;
    }
}
