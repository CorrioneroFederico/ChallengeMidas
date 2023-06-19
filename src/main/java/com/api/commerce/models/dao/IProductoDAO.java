package com.api.commerce.models.dao;

import com.api.commerce.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDAO extends CrudRepository<Producto, Long> {
    Producto findByNombre(String name);
}