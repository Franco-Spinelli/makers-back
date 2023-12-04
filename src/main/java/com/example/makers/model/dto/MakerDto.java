package com.example.makers.model.dto;

import com.example.makers.model.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MakerDto {
    private Integer id;
    private String name;
    private List<Product> products = new ArrayList<>();
}
