package com.codegym.casestudy4.repository;

import com.codegym.casestudy4.entity.Category;
import com.codegym.casestudy4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoriesById(long id);
}
