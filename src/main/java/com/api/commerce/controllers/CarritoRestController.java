package com.api.commerce.controllers;

import com.api.commerce.models.entity.Usuario;
import com.api.commerce.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoRestController {

    @Autowired
    IUsuarioService clienteService;
    @GetMapping("/listado")
    public List<Usuario> index(){
        return clienteService.findAll();
    }
}
