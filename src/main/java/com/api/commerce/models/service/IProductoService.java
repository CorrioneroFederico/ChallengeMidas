package com.api.commerce.models.service;

import com.api.commerce.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public void save(Producto producto);

    public void detele(Long id);

    public Producto findById(Long id);
    public Producto findByName(String name);

    public List<Producto> findAll();

}
