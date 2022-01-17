package com.kushal.org.repository;

import com.kushal.org.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
  public List<Product> findByIdIn(List<Integer> productIds);
}
