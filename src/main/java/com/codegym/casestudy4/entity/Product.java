package com.codegym.casestudy4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME",nullable=false)
    private String name;

    @Column(name = "PRICE",nullable=false)
    private long price;

    //chất liêu
    @Column(name = "MATERIAL",nullable=false)
    private String material;

    @Column(name = "IMAGE_URL",nullable=false)
    private String imageUrl;

    @Column(name = "BRAND",nullable=false)
    private String brand;

    @Column(name = "origin",nullable=false)
    private String origin;

    @Column(name = "description",nullable=false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
