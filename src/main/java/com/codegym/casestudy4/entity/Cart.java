package com.codegym.casestudy4.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "CART")
public class Cart {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartLine> cartLineList;

    @Column(name = "total_price")
    private long subPrice;
}
