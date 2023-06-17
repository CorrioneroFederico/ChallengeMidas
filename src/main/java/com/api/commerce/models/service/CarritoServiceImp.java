package com.api.commerce.models.service;

import com.api.commerce.models.dao.ICarritoDAO;
import com.api.commerce.models.entity.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImp implements ICarritoService {
    @Autowired
    private ICarritoDAO carritoDao;

    @Override
    public List<Carrito> findAll() {
        return (List<Carrito>) this.carritoDao.findAll();
    }
}
