package com.example.udemy_apirest_prod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.udemy_apirest_prod.entity.Usuario;
import com.example.udemy_apirest_prod.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Constructor para inyectar el repositorio
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    
    }
    public Usuario save(Usuario usuario) {
        // Lógica para guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    public List <Usuario> findAll() {
        // Lógica para obtener lista de todos los usuarios de la base de datos
        return  usuarioRepository.findAll();
    }

    //
    public Optional<Usuario> findById(Integer id) {
        // Lógica para encontrar un usuario por su ID
         return  usuarioRepository.findById(id);
    }

    public void deleteById(Integer id) {
        // Logica para borrar usuario
        usuarioRepository.deleteById(id);
    }

    public  Usuario update(Usuario usuario) {
        // Lógica para actualizar el usuario en la base de datos
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());
        Usuario usuarioBD =usuarioExistente.get();

        usuarioBD.setNombreUsuario(usuario.getNombreUsuario());
        usuarioBD.setEmailUsuario(usuario.getEmailUsuario());
        usuarioBD.setNombre(usuario.getNombre());
        usuarioBD.setApellidos(usuario.getApellidos());
        usuarioBD.setIdioma(usuario.getIdioma());
        usuarioBD.setZonaHoraria(usuario.getZonaHoraria());

        return usuarioRepository.save(usuarioBD);
    }

}
