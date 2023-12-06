package com.example.makers.service.maker;

import com.example.makers.model.entity.Maker;
import com.example.makers.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerServiceImpl implements MakerService{
    @Autowired
    private MakerRepository makerRepository;
    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Integer id) {
        return makerRepository.findById(id);
    }

    @Override
    public Maker findByName(String name) {
        return makerRepository.findByName(name);
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void delete(Integer id) {
    makerRepository.deleteById(id);
    }
}
