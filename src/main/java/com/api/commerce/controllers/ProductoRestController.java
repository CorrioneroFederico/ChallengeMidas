package com.api.commerce.controllers;

import com.api.commerce.models.entity.Carrito;
import com.api.commerce.models.entity.ItemCarrito;
import com.api.commerce.models.entity.Producto;
import com.api.commerce.models.entity.Usuario;
import com.api.commerce.models.service.IProductoService;
import com.api.commerce.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    IProductoService productoService;

    @Autowired
    IUsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Producto> listar(){
        return this.productoService.findAll();
    }

    @PostMapping("/cargar")
    public ResponseEntity<String> cargar(@RequestBody Producto producto) {
        if (this.productoService.findByName(producto.getNombre()) != null) {
            return new ResponseEntity("Product already exists", HttpStatus.BAD_REQUEST);
        }
        this.productoService.save(producto);
        return new ResponseEntity("Product registered successfully", HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (this.productoService.findById(id) == null) {
            return new ResponseEntity("Product not exists", HttpStatus.BAD_REQUEST);
        }
        this.productoService.detele(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody Producto producto) {
        if (this.productoService.findById(producto.getId()) == null) {
            return new ResponseEntity("Product not exists", HttpStatus.BAD_REQUEST);
        }
        producto.setFecha(new Date());
        this.productoService.save(producto);
        return new ResponseEntity("Product modified successfully", HttpStatus.OK);
    }

    @PostMapping("/agregar_al_carrito/{id}")
    public ResponseEntity<String> agregarAlCarrito(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Producto producto = this.productoService.findById(id);
        
        if (producto == null){
            return new ResponseEntity("Product not exists", HttpStatus.BAD_REQUEST);
        }
        if (!producto.getDisponible()){
            return new ResponseEntity("No Stock", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = this.usuarioService.findbyUsername(userDetails.getUsername());
        if(usuario.getCarritos().isEmpty() || usuario.getCarritos().get(usuario.getCarritos().size()-1).getPedidoRealizado()){
            Carrito carrito = new Carrito();
            carrito.addItems(new ItemCarrito(producto));
        } else {
            usuario.getCarritos().get(usuario.getCarritos().size()-1).addItems(new ItemCarrito(producto));
            this.usuarioService.save(usuario);
        }
        return new ResponseEntity("Product successfully added to cart", HttpStatus.OK);
    }
}
