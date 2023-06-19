package com.api.commerce.models.service;

import java.util.ArrayList;
import java.util.List;

import com.api.commerce.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

    @Autowired
    private IUsuarioService usuarioService;

    private final Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioService.findbyUsername(username);

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(usuario == null){
            logger.error("Login error: el usuario con el username "+username+" no existe");
            throw new UsernameNotFoundException("Username "+username+" no existe");
        }

        authorities.add(new SimpleGrantedAuthority(usuario.getRol()));

        /*if(authorities.isEmpty()){
            logger.error("Login error: el usuario "+usuario.getUsername()+" no posee roles asignados");
            throw new UsernameNotFoundException("Login error: el usuario "+usuario.getUsername()+" no posee roles asignados");
        }*/

        return new User(usuario.getUsername(),usuario.getPassword(),true,true,true,true,authorities);
    }
}
// El "if" comentado es simplemente para quitar el Waning, ya que siempre van a tener un rol asignado los usuarios.
