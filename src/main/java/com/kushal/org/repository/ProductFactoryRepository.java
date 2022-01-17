package com.kushal.org.repository;

import com.kushal.org.model.ProductFactory;
import org.springframework.data.repository.CrudRepository;

public interface ProductFactoryRepository extends CrudRepository<ProductFactory, Integer> {
  ProductFactory findByProduct(int product);
}
