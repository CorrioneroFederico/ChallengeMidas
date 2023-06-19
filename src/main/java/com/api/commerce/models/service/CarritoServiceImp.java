package com.api.commerce.models.service;

import com.api.commerce.models.dao.ICarritoDAO;
import com.api.commerce.models.entity.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarritoServiceImp implements ICarritoService {

    @Autowired
    private ICarritoDAO carritoDao;

    @Override
    public List<Carrito> fetchByIdWithUIP() {
        return this.carritoDao.fetchByIdWithUIP();
    }

    @Override
    @Transactional
    public void save(Carrito carrito) {
        this.carritoDao.save(carrito);
    }
}
