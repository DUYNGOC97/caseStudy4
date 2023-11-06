package com.codegym.casestudy4.service;

import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductDto> showAllProduct();
    ProductDto findProductById(long id);
}
