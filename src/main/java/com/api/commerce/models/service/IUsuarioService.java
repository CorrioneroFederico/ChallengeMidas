package com.api.commerce.models.service;

import com.api.commerce.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAll();

    Usuario findbyUsername(String username);

    void save(Usuario usuario);
}
