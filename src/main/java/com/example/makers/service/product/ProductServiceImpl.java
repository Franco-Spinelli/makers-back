package com.example.makers.service.product;

import com.example.makers.model.entity.Product;
import com.example.makers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> productsInRange(BigDecimal min, BigDecimal max) {
        return productRepository.productsInRange(min,max);
    }

    /* @Override
     public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {
         return productRepository.findByPriceInRange(min,max);
     }
 */
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
