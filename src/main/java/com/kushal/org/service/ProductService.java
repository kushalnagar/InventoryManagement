package com.kushal.org.service;

import com.kushal.org.model.Product;
import com.kushal.org.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
  @Autowired ProductRepository productRepository;

  public List<Product> getAllProduct(){
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(product -> products.add(product));
    return products;
  }

  public Product getProductById(int id){
    return productRepository.findById(id).get();
  }

  public void save(Product product){
    productRepository.save(product);
  }

  public Product updateProduct(int productId, Product productRequest) {
    return productRepository.findById(productId).map(product -> {
      product.setProductName(productRequest.getProductName());
      return productRepository.save(product);
    }).orElseThrow(()-> new RuntimeException("ProductId" + productId + "not found"));
  }

  public List<Product> getAllProductByProductIds(Set<Integer> keySet) {
    List<Integer> productIds = new ArrayList<>(keySet);
    return productRepository.findByIdIn(productIds);
  }
}
