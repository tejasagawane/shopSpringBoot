package com.stp.shop.repo;

import com.stp.shop.domain.Category;
import com.stp.shop.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color,Long> {
    public List<Color> findAllByOrderByNameAsc();
}
