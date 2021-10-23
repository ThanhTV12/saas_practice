package com.thanh.practice.saas.service.hibernate.impl;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.OrderDetail;
import com.thanh.practice.saas.infrastructure.storage.jpa.entity.User;
import com.thanh.practice.saas.infrastructure.storage.jpa.repository.OrderDetailRepository;
import com.thanh.practice.saas.infrastructure.storage.jpa.repository.UserRepository;
import com.thanh.practice.saas.service.core.BaseService;
import com.thanh.practice.saas.service.core.ServiceContext;
import com.thanh.practice.saas.service.hibernate.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    public UserServiceImpl(ServiceContext serviceContext) {
        super(serviceContext);
    }

    @Override
    public List<User> loadAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public Set<OrderDetail> findOdersByUserid(Long userId) {
        User user = userRepository.findOne(userId);
        if (user == null || user.getOrderDetail().isEmpty()) {
            return Collections.emptySet();
        }
        return user.getOrderDetail();
    }

    @Override
    public List<OrderDetail> findAllOrder() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<User> save(List<User> users) {
        return userRepository.save(users);
    }

    @Override
    public User saveOne(User user) {
        return userRepository.save(user);
    }
}
