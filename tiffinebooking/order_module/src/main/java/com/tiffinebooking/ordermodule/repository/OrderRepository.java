package com.tiffinebooking.ordermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiffinebooking.ordermodule.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}