package com.api.commerce.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotEmpty
    private String username;

    @Column(nullable = false)
    @NotEmpty
    private String password;

    @Column(unique = true, nullable = false)
    @NotEmpty
    private String email;

    @NotEmpty
    private String rol;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;

    public Usuario(){
        this.carritos = new ArrayList<>();
    }

    public void addPedido(Carrito carrito){
        this.carritos.add(carrito);
    }

    @Serial
    private static final long serialVersionUID = 1L;
}