package com.api.commerce.models.dao;

import com.api.commerce.models.entity.Carrito;
import org.springframework.data.repository.CrudRepository;
public interface ICarritoDAO extends CrudRepository<Carrito, Long> {
}