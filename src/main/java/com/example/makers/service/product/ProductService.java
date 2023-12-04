package com.example.makers.service.product;

import com.example.makers.model.entity.Maker;
import com.example.makers.model.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();
    Optional<Product>findById(Integer id);
    List<Product>  productsInRange(BigDecimal min, BigDecimal max);
    void save (Product product);
    void delete(Integer id);
}
