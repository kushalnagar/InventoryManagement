package com.kushal.org.bean;

import java.util.ArrayList;
import java.util.List;

public class ProductNode {
  int id;
  List<ProductNode> rawProduct = new ArrayList<>();
  int NoOfDays;

  public ProductNode(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<ProductNode> getRawProduct() {
    return rawProduct;
  }

  public void setRawProduct(List<ProductNode> rawProduct) {
    this.rawProduct = rawProduct;
  }

  public int getNoOfDays() {
    return NoOfDays;
  }

  public void setNoOfDays(int noOfDays) {
    NoOfDays = noOfDays;
  }
}
