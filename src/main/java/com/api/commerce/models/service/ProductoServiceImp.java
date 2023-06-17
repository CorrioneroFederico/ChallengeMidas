package com.api.commerce.models.service;

import com.api.commerce.models.dao.IProductoDAO;
import com.api.commerce.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService {
    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public void save(Producto producto) {
        this.productoDAO.save(producto);
    }

    @Override
    public void detele(Long id) {
        this.productoDAO.deleteById(id);
    }

    @Override
    public Producto findById(Long id ) {
        return this.productoDAO.findById(id).orElse(null);
    }

    @Override
    public Producto findByName(String name) {
        return this.productoDAO.findByNombre(name);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) this.productoDAO.findAll();
    }
}
