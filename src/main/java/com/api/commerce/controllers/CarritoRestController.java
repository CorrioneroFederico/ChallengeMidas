package com.api.commerce.controllers;

import com.api.commerce.models.entity.Carrito;
import com.api.commerce.models.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrito")
public class CarritoRestController {

    @Autowired
    ICarritoService carritoService;

    @GetMapping("/listar")
    public List<Carrito> listar(){
        return this.carritoService.findAll().stream().filter( carrito -> carrito.getPedidoRealizado()).collect(Collectors.toList());
    }
}
