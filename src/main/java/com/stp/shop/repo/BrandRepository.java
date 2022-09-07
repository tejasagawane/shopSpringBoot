package com.stp.shop.repo;

import com.stp.shop.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    public List<Brand> findAllByOrderByNameAsc();
}
