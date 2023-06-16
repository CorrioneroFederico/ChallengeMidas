package com.api.commerce.models.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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
    @NotNull
    private String username;
    @Column(nullable = false)
    @NotNull
    private String password;
    @Column(unique = true, nullable = false)
    @NotNull
    private String email;
    @NotNull
    private String rol;

}