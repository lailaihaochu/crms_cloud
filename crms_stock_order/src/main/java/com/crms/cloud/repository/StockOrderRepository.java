package com.crms.cloud.repository;

import com.crms.cloud.dto.StockOrderEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockOrderRepository extends JpaRepository<StockOrderEntity, String> {
    List<StockOrderEntity> findAll(Specification specification);
}
