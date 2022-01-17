package com.kushal.org.service;

import com.kushal.org.model.Inventory;
import com.kushal.org.repository.InventoryRepository;
import com.kushal.org.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
  @Autowired InventoryRepository inventoryRepository;

  @Autowired ProductRepository productRepository;
  public List<Inventory> getAllInventory(){
    List<Inventory> Inventories = new ArrayList<>();
    inventoryRepository.findAll().forEach(inventory -> Inventories.add(inventory));
    return Inventories;
  }

  public Inventory getInventoryById(int id){
    return inventoryRepository.findById(id).get();
  }

  public void save(Inventory product){
    inventoryRepository.save(product);
  }

  public List<Inventory> findByProductId(int productId) {
    return inventoryRepository.findByProductId(productId);
  }

  public void createInventory(int productId, Inventory inventory) {
    productRepository.findById(productId).map(product -> {
      inventory.setProduct(product);
      return inventoryRepository.save(inventory);
    });
  }
}
