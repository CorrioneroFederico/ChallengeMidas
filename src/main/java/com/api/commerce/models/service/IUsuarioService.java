package com.api.commerce.models.service;

import com.api.commerce.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario findbyUsername(String username);

    public void save(Usuario usuario);
}
