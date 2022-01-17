package com.kushal.org.controller;

import com.kushal.org.model.Inventory;
import com.kushal.org.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InventoryController {
  @Autowired InventoryService inventoryService;

  @GetMapping("/product/{id}/inventory")
  private List<Inventory> getAllInventoryByProductId(@PathVariable (value = "id") int productId){
    return inventoryService.findByProductId(productId);
  }

  @PostMapping("/product/{id}/inventory")
  private int createInventory(@PathVariable (value = "id") int productId,
      @Valid @RequestBody Inventory inventory){
    inventoryService.createInventory(productId,inventory);
    return inventory.getId();
  }
}
