package com.example.udemy_apirest_prod.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.udemy_apirest_prod.dto.ComentarioUsuarioDTO;
import com.example.udemy_apirest_prod.entity.Comentario;
import com.example.udemy_apirest_prod.entity.Usuario;
import com.example.udemy_apirest_prod.repository.ComentarioRepository;
import com.example.udemy_apirest_prod.repository.UsuarioRepository;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, UsuarioRepository usuarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Comentario save(Comentario comentario) {
        // Establecer la fecha de creación si no está establecida
        if (comentario.getFechaComentario() == null) {
            comentario.setFechaComentario(LocalDateTime.now());
        }
        
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    public void deleteById(Integer id) {
        comentarioRepository.deleteById(id);
    }
    public Comentario crearComentario(String texto, Integer usuarioId) {
        Comentario comentario = new Comentario();
        comentario.setTextoComentario(texto);
        comentario.setFechaComentario(LocalDateTime.now());
        
        // Buscar y establecer el usuario si existe
        if (usuarioId != null) {
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
            if (usuarioOpt.isPresent()) {
                comentario.setUsuario(usuarioOpt.get());
            }
        }
        
        return comentarioRepository.save(comentario);
    }

    public List<ComentarioUsuarioDTO> obtenerComentariosConUsuario() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        List<ComentarioUsuarioDTO> dtoList = new ArrayList<>();

        for (Comentario comentario : comentarios) {
            Usuario usuario = comentario.getUsuario();
            
            // Verificar si el usuario existe antes de crear el DTO
            if (usuario != null) {
                ComentarioUsuarioDTO dto = new ComentarioUsuarioDTO(
                    usuario.getNombreUsuario() != null ? usuario.getNombreUsuario() : usuario.getNombre(),
                    usuario.getEmailUsuario(),
                    comentario.getTextoComentario(),
                    comentario.getFechaComentario()
                );
                dtoList.add(dto);
            }
        }

        return dtoList;
    }
}
