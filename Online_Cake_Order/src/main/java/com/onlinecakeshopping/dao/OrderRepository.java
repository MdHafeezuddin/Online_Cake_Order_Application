package com.onlinecakeshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinecakeshopping.model.Order;

//it is used to indicate the class provides crud operations by extending to the jpa
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
