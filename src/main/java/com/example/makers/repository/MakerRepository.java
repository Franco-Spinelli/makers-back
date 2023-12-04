package com.example.makers.repository;

import com.example.makers.model.entity.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker,Integer> {
}
