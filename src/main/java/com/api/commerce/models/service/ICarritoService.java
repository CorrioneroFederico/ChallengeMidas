package com.api.commerce.models.service;

import com.api.commerce.models.entity.Carrito;

import java.util.List;

public interface ICarritoService {

    List<Carrito> fetchByIdWithUIP();

    void save(Carrito carrito);

}
