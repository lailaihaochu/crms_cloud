package com.crms.cloud.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="stock_order")
@Data
public class StockOrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    BigDecimal endPrice;
    BigDecimal increase;
    BigDecimal amplitude;
    BigDecimal totalAmount;
    BigDecimal turnoverRate;
    BigDecimal circulationMarketValue;
    @CreatedDate
    private Timestamp createdTime;

    private Timestamp updatedTime;

    String name;
    String code;
    String remark;


}
