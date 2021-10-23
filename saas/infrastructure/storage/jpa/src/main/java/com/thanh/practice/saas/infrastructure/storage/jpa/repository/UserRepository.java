package com.thanh.practice.saas.infrastructure.storage.jpa.repository;

import com.thanh.practice.saas.infrastructure.storage.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
