package com.example.udemy_apirest_prod.controller;

import com.example.udemy_apirest_prod.entity.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGuardarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("yohel");
        usuario.setEmailUsuario("yohel@ejemplo.com");

        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombreUsuario").value("yohel"))
                .andExpect(jsonPath("$.emailUsuario").value("yohel@ejemplo.com"));
    }

    @Test
    void testListarUsuarios() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNumber());
    }

    @Test
    void testBuscarUsuarioPorId() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("ana");
        usuario.setEmailUsuario("ana@ejemplo.com");

        String body = objectMapper.writeValueAsString(usuario);

        String response = mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        Usuario guardado = objectMapper.readValue(response, Usuario.class);

        mockMvc.perform(get("/usuarios/" + guardado.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreUsuario").value("ana"));
    }

    @Test
    void testActualizarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("luis");
        usuario.setEmailUsuario("luis@ejemplo.com");

        String body = objectMapper.writeValueAsString(usuario);

        String response = mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        Usuario guardado = objectMapper.readValue(response, Usuario.class);
        guardado.setNombreUsuario("luis actualizado");

        mockMvc.perform(put("/usuarios/" + guardado.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(guardado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreUsuario").value("luis actualizado"));
    }

    @Test
    void testEliminarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("borrar");
        usuario.setEmailUsuario("borrar@ejemplo.com");

        String body = objectMapper.writeValueAsString(usuario);

        String response = mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        Usuario guardado = objectMapper.readValue(response, Usuario.class);

        mockMvc.perform(delete("/usuarios/" + guardado.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuario eliminado correctamente"));
    }
}
