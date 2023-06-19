package com.api.commerce.models.service;

import com.api.commerce.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    void save(Producto producto);

    void detele(Long id);

    Producto findById(Long id);
    Producto findByName(String name);

    List<Producto> findAll();

}
