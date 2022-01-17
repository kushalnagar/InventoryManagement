package com.kushal.org.repository;

import com.kushal.org.model.Inventory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
  List<Inventory> findByProductId(Integer productId);
}
