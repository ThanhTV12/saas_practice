package com.thanh.practice.saas.service.hibernate;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.OrderDetail;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> loadAll();
    User findById(Long  userId);
    Set<OrderDetail> findOdersByUserid(Long  userId);
    List<OrderDetail> findAllOrder();
    List<User> save(List<User> users);
    User saveOne(User user);
}
