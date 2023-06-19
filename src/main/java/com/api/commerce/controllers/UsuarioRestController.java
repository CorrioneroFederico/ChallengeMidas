package com.api.commerce.controllers;

import com.api.commerce.models.entity.Usuario;
import com.api.commerce.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService clienteService;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        if (usuarioService.findbyUsername(usuario.getUsername()) != null) {
            return new ResponseEntity<>("El nombre de usuario no esta disponible.", HttpStatus.BAD_REQUEST);
        }

        usuarioService.save(usuario);
        return new ResponseEntity<>("Se ha registrado exitosamente.", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value = "error", required = false) String error, Principal principal) {
        if (principal == null) {
            return new ResponseEntity<>("Error en el login: Nombre de usuario y/o contraseña incorrecta, por favor vuelva a intentarlo", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Bienvenido " + principal.getName(), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("Se ha deslogeado con exito.", HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Usuario> list(){
        return clienteService.findAll();
    }
}
