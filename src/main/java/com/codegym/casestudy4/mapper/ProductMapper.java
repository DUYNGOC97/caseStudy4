package com.codegym.casestudy4.mapper;

import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductDto mapToDTO(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory());
        dto.setMaterial(product.getMaterial());
        dto.setImageUrl(product.getImageUrl());
        dto.setBrand(product.getBrand());
        dto.setDescription(product.getDescription());
        dto.setOrigin(product.getOrigin());
        return dto;
    }
    public static Product mapToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setMaterial(productDto.getMaterial());
        product.setImageUrl(productDto.getImageUrl());
        return product;
    }
    public static List<ProductDto> mapToDTO(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product:productList){
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setCategory(product.getCategory());
            dto.setMaterial(product.getMaterial());
            dto.setImageUrl(product.getImageUrl());
            productDtoList.add(dto);
        }
        return productDtoList;
    }
}
