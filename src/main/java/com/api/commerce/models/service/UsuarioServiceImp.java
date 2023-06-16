package com.api.commerce.models.service;

import com.api.commerce.models.dao.IUsuarioDAO;
import com.api.commerce.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImp implements IUsuarioService {
    @Autowired
    private IUsuarioDAO usuarioDao;
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Usuario findbyUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }
}
