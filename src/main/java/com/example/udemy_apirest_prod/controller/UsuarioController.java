package com.example.udemy_apirest_prod.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.udemy_apirest_prod.entity.Usuario;
import com.example.udemy_apirest_prod.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Inyectar el servicio de usuario
    private UsuarioService usuarioService;

    // Constructor para inyectar el servicio
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }  
    
    //metedo para guardar usuario en la base de datos ademas se implementa ResponseEntity para devolver el estado HTTP 201 
    //(CREATED) cuando se crea un nuevo usuario
    //POST http://localhost:8081/usuarios
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    //GET http://localhost:8081/usuarios
    //peticion GET para listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    //GET http://localhost:8081/usuarios/{id} 
    //Peticion GET para buscar usuario por ID ademas se implementa ResponseEntity para manejar el caso en que el usuario no se encuentra con expresion lambda
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        return usuarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //PUT http://localhost:8081/usuarios/{id}
    //Peticion PUT para actualizar usuario por ID
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
    Optional<Usuario> usuarioOptional = usuarioService.findById(id);
    if (usuarioOptional.isPresent()) {
        usuario.setId(id); // Asegura que se actualice el usuario correcto
        return ResponseEntity.ok(usuarioService.update(usuario));
    } else {
        return ResponseEntity.notFound().build();
    }
}


    //DELETE http://localhost:8081/usuarios/{id}
    //Peticion DELETE para borrar usuario por ID
    @DeleteMapping("{id}")
    public String deleteById(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return("Usuario eliminado correctamente");
    }

}