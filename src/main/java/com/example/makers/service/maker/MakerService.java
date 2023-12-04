package com.example.makers.service.maker;

import com.example.makers.model.entity.Maker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MakerService {
    List<Maker> findAll();
    Optional<Maker>findById(Integer id);
    void save (Maker maker);
    void delete(Integer id);
}
