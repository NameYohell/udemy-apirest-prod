package com.example.udemy_apirest_prod.service;

import com.example.udemy_apirest_prod.entity.Usuario;
import com.example.udemy_apirest_prod.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testGuardarUsuarioDesdeService() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("yohel");
        usuario.setEmailUsuario("yohel@ejemplo.com");

        Usuario guardado = usuarioService.save(usuario);
        assertNotNull(guardado.getId(), "El ID debe generarse al guardar");
        assertEquals("yohel@ejemplo.com", guardado.getEmailUsuario(), "El email debe coincidir");
    }

    @Test
    void testListarUsuariosDesdeService() {
        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario("ana");
        usuario1.setEmailUsuario("ana@ejemplo.com");

        Usuario usuario2 = new Usuario();
        usuario2.setNombreUsuario("luis");
        usuario2.setEmailUsuario("luis@ejemplo.com");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        List<Usuario> usuarios = usuarioService.findAll();
        assertTrue(usuarios.size() >= 2, "Debe haber al menos dos usuarios");
    }
}
