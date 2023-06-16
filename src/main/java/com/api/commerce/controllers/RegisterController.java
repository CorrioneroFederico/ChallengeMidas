package com.api.commerce.controllers;

import com.api.commerce.models.entity.Usuario;
import com.api.commerce.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        if (usuarioService.findbyUsername(usuario.getUsername()) != null) {
            return new ResponseEntity("Username already exists", HttpStatus.BAD_REQUEST);
        }
        usuarioService.save(usuario);
        return new ResponseEntity("User registered successfully", HttpStatus.OK);
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "error", required = false) String error, Principal principal) {
        if (principal != null) {
            return new ResponseEntity("Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Se ha logeado con éxito", HttpStatus.OK);
    }

    @GetMapping("/hola")
    public ResponseEntity<String> hola() {
        return new ResponseEntity("SIUU", HttpStatus.OK);
    }
}

