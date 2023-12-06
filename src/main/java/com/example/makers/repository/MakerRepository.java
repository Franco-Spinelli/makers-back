package com.example.makers.repository;

import com.example.makers.model.entity.Maker;
import com.example.makers.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MakerRepository extends CrudRepository<Maker,Integer> {
    @Query("SELECT m FROM Maker m WHERE m.name = :name")
    Maker findByName(@Param("name") String name);
}