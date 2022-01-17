package com.kushal.org.bean;

import com.kushal.org.model.Product;

public class ProductOrderQuantity extends Product {
  int quantity;

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
