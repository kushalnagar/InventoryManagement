package com.kushal.org.controller;

import com.kushal.org.model.Inventory;
import com.kushal.org.model.Product;
import com.kushal.org.model.ProductFactory;
import com.kushal.org.service.ProductFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
public class ProductFactoryController {
  @Autowired ProductFactoryService productFactoryService;

  @GetMapping("/product/{id}/productfactory")
  private Set<Integer> getAllRequireProductsForProduct(@PathVariable (value = "id") int productId){
    return productFactoryService.getAllProductsByProductId(productId);
  }


  @PostMapping("/product/{id}/productfactory")
  private int createProductFactory(@PathVariable(value = "id") int productId,
      @Valid @RequestBody ProductFactory productFactory){
    productFactoryService.createProductFactory(productId, productFactory);
    return productFactory.getId();
  }
}
