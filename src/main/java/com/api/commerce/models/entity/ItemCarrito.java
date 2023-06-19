package com.api.commerce.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "carrito_items")
public class ItemCarrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public ItemCarrito(){}

    public ItemCarrito(Producto producto){
        this.producto = producto;
        this.cantidad = 1;
    }

    public Double importeTotal(){
        return cantidad.doubleValue()*producto.getPrecio();
    }

    @Serial
    private static final long serialVersionUID = 1L;
}