package com.stp.shop.repo;

import com.stp.shop.domain.Brand;
import com.stp.shop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public List<Category> findAllByOrderByNameAsc();
}
