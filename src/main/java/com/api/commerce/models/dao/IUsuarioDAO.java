package com.api.commerce.models.dao;

import com.api.commerce.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}