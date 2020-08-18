package com.tacos.springapp.repo;

import com.tacos.springapp.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
