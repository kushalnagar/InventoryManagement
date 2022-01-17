package com.kushal.org.service;

import com.kushal.org.model.ProductFactory;
import com.kushal.org.repository.ProductFactoryRepository;
import com.kushal.org.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductFactoryService {
  @Autowired ProductFactoryRepository productFactoryRepository;

  @Autowired ProductRepository productRepository;

  public List<ProductFactory> getAllProductRequirement(){
    List<ProductFactory> productFactories = new ArrayList<>();
    productFactoryRepository.findAll().forEach(productFactory ->
            productFactories.add(productFactory)
        );
    return productFactories;
  }

  public int save(ProductFactory productFactory){
    productFactoryRepository.save(productFactory);
    return productFactory.getId();
  }

  public void createProductFactory(int productId, ProductFactory productFactory) {
    productRepository.findById(productId).map(product -> {
      productFactory.setProduct(product.getId());
      return productFactoryRepository.save(productFactory);
    });
  }

  public Set<Integer> getAllProductsByProductId(int productId) {
    ProductFactory factory = productFactoryRepository.findByProduct(productId);
    return factory.getRawProductList();
  }
}
