package com.kushal.org.bean;

import java.util.List;

public class SuggestionDetail {

  private List<ProductOrderQuantity> productToBeOrdered;
  private int noOfDays;

  public List<ProductOrderQuantity> getProductToBeOrdered() {
    return productToBeOrdered;
  }

  public void setProductToBeOrdered(List<ProductOrderQuantity> productToBeOrdered) {
    this.productToBeOrdered = productToBeOrdered;
  }

  public int getNoOfDays() {
    return noOfDays;
  }

  public void setNoOfDays(int noOfDays) {
    this.noOfDays = noOfDays;
  }
}
