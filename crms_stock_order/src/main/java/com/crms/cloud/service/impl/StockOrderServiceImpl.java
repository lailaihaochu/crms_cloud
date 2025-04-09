package com.crms.cloud.service.impl;

import com.crms.cloud.dto.StockOrderEntity;
import com.crms.cloud.repository.StockOrderRepository;
import com.crms.cloud.service.StockOrderService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockOrderServiceImpl implements StockOrderService {
    @Resource
    StockOrderRepository stockOrderRepository;
    @Override
    public List<StockOrderEntity> getStockOrderList(Timestamp startCreateTime, Timestamp endCreateTime) {
        Specification specification=(Specification<StockOrderEntity>)(root,criteriaQuery,criteriaBuilder)->{
          List<Predicate> predicates=new ArrayList<>();
          if(startCreateTime!=null && endCreateTime!=null){
              predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdTime"),startCreateTime));
              predicates.add(criteriaBuilder.lessThan(root.get("createdTime"),endCreateTime));
          }
          Predicate[] predicate=new Predicate[predicates.size()];
          return criteriaBuilder.and(predicates.toArray(predicate));
        };
        List<StockOrderEntity> stockOrderEntities=stockOrderRepository.findAll(specification);
        return stockOrderEntities;
    }

    @Override
    public List<StockOrderEntity> getStockOrderList() {
        Specification specification=(Specification<StockOrderEntity>)(root,criteriaQuery,criteriaBuilder)->{
            List<Predicate> predicates=new ArrayList<>();
            Predicate[] predicate=new Predicate[0];
            return criteriaBuilder.and(predicates.toArray(predicate));
        };
        List<StockOrderEntity> stockOrderEntities=stockOrderRepository.findAll(specification);
        return stockOrderEntities;
    }
}
