package com.codegym.casestudy4.dto;

import com.codegym.casestudy4.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private long price;

    //chất liêu
    @NotEmpty
    private String material;

    @NotEmpty
    private String imageUrl;

    @NotEmpty
    private String formattedPrice;

    private String brand;

    private String origin;

    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
