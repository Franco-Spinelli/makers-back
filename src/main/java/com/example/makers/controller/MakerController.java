package com.example.makers.controller;

import com.example.makers.model.dto.MakerDto;
import com.example.makers.model.entity.Maker;
import com.example.makers.service.maker.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {
    @Autowired
    private MakerService makerService;
    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody MakerDto makerDto) throws URISyntaxException {
        if(makerDto.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        makerService.save(Maker.builder()
                        .name(makerDto.getName())
                        .id(makerDto.getId())
                        .build());
    return ResponseEntity.created(new URI("api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@RequestBody MakerDto makerDto, @PathVariable Integer id){
        Optional<Maker> makerOptional = makerService.findById(id);
        if(makerOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Maker maker = makerOptional.get();
        maker.setName(makerDto.getName());
        makerService.save(maker);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MakerDto> makerDtoList = makerService.findAll().stream()
                .map(maker -> MakerDto.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .products(maker.getProducts())
                        .build())
                .toList();
        return ResponseEntity.ok(makerDtoList);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Maker> optionalMaker = makerService.findById(id);
        if (optionalMaker.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Maker maker = optionalMaker.get();
        MakerDto makerDto = MakerDto.builder()
                .name(maker.getName())
                .id(maker.getId())
                .products(maker.getProducts()).build();
        return ResponseEntity.ok(makerDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        Optional<Maker>makerOptional = makerService.findById(id);
        if(makerOptional.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        makerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
