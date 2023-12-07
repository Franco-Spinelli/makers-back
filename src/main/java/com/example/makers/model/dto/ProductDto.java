package com.example.makers.model.dto;

import com.example.makers.model.entity.Maker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String makerName;
}
