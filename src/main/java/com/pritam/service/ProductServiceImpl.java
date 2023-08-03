package com.pritam.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.entity.Product;
import com.pritam.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

 private final ProductRepository productRepository;

 @Autowired
 public ProductServiceImpl(ProductRepository productRepository) {
     this.productRepository = productRepository;
 }

 @Override
 public List<Product> getAllProducts() {
     return productRepository.findAll();
 }

 @Override
 public Product getProductById(Integer id) {
     Optional<Product> optionalProduct = productRepository.findById(id);
     return optionalProduct.orElse(null);
 }

 @Override
 public Product createProduct(Product product) {
     return productRepository.save(product);
 }

 @Override
 public Product updateProduct(Integer id, Product product) {
     Optional<Product> optionalProduct = productRepository.findById(id);
     if (optionalProduct.isPresent()) {
         Product existingProduct = optionalProduct.get();
         existingProduct.setName(product.getName());
         existingProduct.setPrice(product.getPrice());
         existingProduct.setProdcutDescription(product.getProdcutDescription());
         existingProduct.setExpiryDate(product.getExpiryDate());
         
         return productRepository.save(existingProduct);
     } else {
         return null;
     }
 }

 @Override
 public void deleteProduct(Integer id) {
     productRepository.deleteById(id);
 }
}