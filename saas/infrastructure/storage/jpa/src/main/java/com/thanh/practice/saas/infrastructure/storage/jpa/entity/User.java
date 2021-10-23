package com.thanh.practice.saas.infrastructure.storage.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
public class User  implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    @Transient
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    @BatchSize(size = 1)
//    @Fetch(FetchMode.SUBSELECT)
    private Set<OrderDetail> orderDetail = new HashSet<>();


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonManagedReference
//    @JsonBackReference

    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", orderDetail=" + orderDetail.toString() +
                '}';
    }
}
