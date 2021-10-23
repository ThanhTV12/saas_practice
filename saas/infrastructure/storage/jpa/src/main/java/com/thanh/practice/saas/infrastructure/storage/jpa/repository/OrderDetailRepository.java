package com.thanh.practice.saas.infrastructure.storage.jpa.repository;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
