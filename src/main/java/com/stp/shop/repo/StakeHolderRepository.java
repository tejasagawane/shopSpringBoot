package com.stp.shop.repo;

import com.stp.shop.domain.StakeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StakeHolderRepository extends JpaRepository<StakeHolder,Long> {
}
