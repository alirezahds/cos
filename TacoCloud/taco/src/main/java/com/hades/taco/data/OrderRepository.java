package com.hades.taco.data;

import com.hades.taco.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
