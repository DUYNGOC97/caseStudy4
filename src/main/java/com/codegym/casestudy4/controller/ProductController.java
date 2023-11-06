package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.dto.CategoryDto;
import com.codegym.casestudy4.dto.ProductDto;
import com.codegym.casestudy4.dto.UserDto;
import com.codegym.casestudy4.entity.Category;
import com.codegym.casestudy4.entity.Product;
import com.codegym.casestudy4.entity.User;
import com.codegym.casestudy4.mapper.CategoryMapper;
import com.codegym.casestudy4.mapper.ProductMapper;
import com.codegym.casestudy4.mapper.UserMapper;
import com.codegym.casestudy4.service.CategoryService;
import com.codegym.casestudy4.service.ProductService;
import com.codegym.casestudy4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductController {
    ProductService productService;
    CategoryService categoryService;
    UserService userService;

    public ProductController(ProductService productService,CategoryService categoryService,UserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/index")
    public String showProduct(Model model) {
        List<ProductDto> productDtoList = productService.showAllProduct();
        model.addAttribute("productList", productDtoList);
        return "index";
    }

    @GetMapping("/index/id={id}")
    public String customerHome(@PathVariable Long id, Model model) {
        UserDto userDto = userService.findUserById(id);
        List<ProductDto> productDtoList = productService.showAllProduct();
        model.addAttribute("user",userDto);
        model.addAttribute("productList", productDtoList);
        return "index";
    }

    @GetMapping("/single-product/{userId}/{productId}")
    public String showSingleProductCustomer(@PathVariable Long productId,@PathVariable Long userId, Model model) {
        UserDto userDto = userService.findUserById(userId);
        ProductDto productDto = productService.findProductById(productId);
        CategoryDto categoryDto = categoryService.findCategoryByCustomerId(productDto);
        model.addAttribute("user", userDto);
        model.addAttribute("category", categoryDto);
        model.addAttribute("product", productDto);
        return "single-product";
    }
    @GetMapping("/product/{id}")
    public String showSingleProduct(@PathVariable Long id, Model model) {
        ProductDto productDto = productService.findProductById(id);
        CategoryDto categoryDto = categoryService.findCategoryByCustomerId(productDto);
        model.addAttribute("category", categoryDto);
        model.addAttribute("product", productDto);
        return "single-product";
    }
}
