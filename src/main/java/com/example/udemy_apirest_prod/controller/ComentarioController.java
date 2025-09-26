package com.example.udemy_apirest_prod.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

import com.example.udemy_apirest_prod.dto.ComentarioUsuarioDTO;
import com.example.udemy_apirest_prod.entity.Comentario;
import com.example.udemy_apirest_prod.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<Comentario> save(@RequestBody Comentario comentario) {
        return new ResponseEntity<>(comentarioService.save(comentario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> findAll() {
        return ResponseEntity.ok(comentarioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        comentarioService.deleteById(id);
        return ResponseEntity.ok("Comentario eliminado correctamente");
    }
    @GetMapping("/dto")
    public ResponseEntity<List<ComentarioUsuarioDTO>> obtenerComentariosConUsuario() {
    return ResponseEntity.ok(comentarioService.obtenerComentariosConUsuario());
    }

}
