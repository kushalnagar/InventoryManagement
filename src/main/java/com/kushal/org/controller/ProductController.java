package com.kushal.org.controller;

import com.kushal.org.model.Product;
import com.kushal.org.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
  @Autowired ProductService productService;

  @GetMapping("/product")
  private List<Product> getAllProduct(){
    return productService.getAllProduct();
  }

  @GetMapping("/product/{id}")
  private Product getProduct(@PathVariable int id){
    return productService.getProductById(id);
  }

  @PostMapping("/product")
  private int saveProduct(@RequestBody Product product){
    productService.save(product);
    return product.getId();
  }

  @PutMapping("/product/{id}")
  private Product updateProduct(@PathVariable int productId, @Valid @RequestBody Product productRequest){
    return productService.updateProduct(productId, productRequest);
  }
}
