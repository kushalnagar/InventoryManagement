package com.kushal.org.bean;

import com.kushal.org.model.Product;

public class Suggestion{

  private Product product;

  private SuggestionDetail suggestionDetail;

  private String suggestionURL;

  public SuggestionDetail getSuggestionDetail() {
    return suggestionDetail;
  }

  public void setSuggestionDetail(SuggestionDetail suggestionDetail) {
    this.suggestionDetail = suggestionDetail;
  }

  public String getSuggestionURL() {
    return suggestionURL;
  }

  public void setSuggestionURL(String suggestionURL) {
    this.suggestionURL = suggestionURL;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
