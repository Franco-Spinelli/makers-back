package com.example.makers.repository;

import com.example.makers.model.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Query("SELECT p FROM Product p" +
            " WHERE p.price >= :min AND p.price <= :max")
    List<Product> productsInRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
}
