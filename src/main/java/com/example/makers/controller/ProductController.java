package com.example.makers.controller;

import com.example.makers.model.dto.ProductDto;
import com.example.makers.model.entity.Maker;
import com.example.makers.model.entity.Product;
import com.example.makers.service.maker.MakerService;
import com.example.makers.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MakerService makerService;
    @GetMapping("/findById/{id}")
    public ResponseEntity<?>findById(@PathVariable Integer id){
        Optional<Product>productOptional = productService.findById(id);
        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Product product = productOptional.get();
        ProductDto productDto = ProductDto.builder()
                .id(product.getId_product())
                .name(product.getName())
                .price(product.getPrice())
                .maker(product.getMaker())
                .build();
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/range/{min}/{max}")
    public ResponseEntity<?>productsInRange(@PathVariable BigDecimal min, @PathVariable BigDecimal max){
        List<Product>productList = productService.productsInRange(min,max);
        if(productList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productList);
    }
    @PostMapping("/save")
    public ResponseEntity<?>save(@RequestBody ProductDto productDto) throws URISyntaxException {
        Optional<Maker> makerOptional = makerService.findById(productDto.getMaker().getId());
        if (makerOptional.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        else if(productDto.getPrice() == null || productDto.getName().isBlank() || productDto.getMaker() == null){
            return ResponseEntity.notFound().build();
        }
        productService.save(Product.builder()
                        .id_product(productDto.getId())
                        .maker(productDto.getMaker())
                        .price(productDto.getPrice())
                        .name(productDto.getName())
                        .build());
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@RequestBody ProductDto productDto, @PathVariable Integer id){
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        productService.save(Product.builder()
                        .id_product(id)
                        .name(productDto.getName())
                        .price(productDto.getPrice())
                        .maker(productDto.getMaker())
                        .build());

        return  ResponseEntity.ok("Successful change");
    }
}
