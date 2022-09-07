package com.stp.shop.repo;

import com.stp.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Product,Long> {
    List<Product> findByStatus(String status);
}
