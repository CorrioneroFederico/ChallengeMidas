package com.api.commerce.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carritos")
public class Carrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrito_id")
    private List<ItemCarrito> items;

    public Carrito(){
        this.items = new ArrayList<>();
    }

    @PrePersist
    public void prePersist(){
        this.fecha = new Date();
    }

    public void addItems(ItemCarrito item){
        this.items.add(item);
    }

    public Double percioTotal(){
        return this.items.stream().mapToDouble(ItemCarrito :: importeTotal).sum();
    }
    @Serial
    private static final long serialVersionUID = 1L;
}