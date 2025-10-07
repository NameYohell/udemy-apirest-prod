package com.example.udemy_apirest_prod.repository;

import com.example.udemy_apirest_prod.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testGuardarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("yohel");
        usuario.setEmailUsuario("yohel@ejemplo.com");

        Usuario guardado = usuarioRepository.save(usuario);
        assertNotNull(guardado.getId(), "El ID no debe ser nulo después de guardar");
    }

    @Test
    void testBuscarPorId() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("ana");
        usuario.setEmailUsuario("ana@ejemplo.com");
        Usuario guardado = usuarioRepository.save(usuario);

        Optional<Usuario> resultado = usuarioRepository.findById(guardado.getId());
        assertTrue(resultado.isPresent(), "Debe encontrar el usuario por ID");
        assertEquals("ana", resultado.get().getNombreUsuario(), "El nombre de usuario debe coincidir");
    }
}
