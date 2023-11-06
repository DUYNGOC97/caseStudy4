package com.codegym.casestudy4.service.impl;

import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.entity.Product;
import com.codegym.casestudy4.mapper.ProductMapper;
import com.codegym.casestudy4.repository.ProductRepository;
import com.codegym.casestudy4.service.ProductService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Service

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<ProductDto> showAllProduct(){
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = ProductMapper.mapToDTO(productList);
        for (ProductDto productDto : productDtoList) {
            productDto.setFormattedPrice(formatPrice(productDto.getPrice()));
        }
        return productDtoList;
    }
    public String formatPrice(double price) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return nf.format(price);
    }
    public ProductDto findProductById(long id){
        Product product = productRepository.findProductById(id);
        ProductDto productDto = ProductMapper.mapToDTO(product);
        productDto.setFormattedPrice(formatPrice(productDto.getPrice()));
        return productDto;
    }
}
