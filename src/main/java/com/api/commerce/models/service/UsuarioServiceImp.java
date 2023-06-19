package com.api.commerce.models.service;

import com.api.commerce.models.dao.IUsuarioDAO;
import com.api.commerce.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findbyUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioDao.save(usuario);
    }
}
