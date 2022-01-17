package com.kushal.org.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Set;

@Entity
public class ProductFactory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;

  @Column
  private int product;

  @Column
  @ElementCollection(targetClass=Integer.class)
  private Set<Integer> rawProductList;

  @Column
  private int noOfDays;

  public int getProduct() {
    return product;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setProduct(int product) {
    this.product = product;
  }

  public Set<Integer> getRawProductList() {
    return rawProductList;
  }

  public void setRawProductList(Set<Integer> rawProductList) {
    this.rawProductList = rawProductList;
  }

  public int getNoOfDays() {
    return noOfDays;
  }

  public void setNoOfDays(int noOfDays) {
    this.noOfDays = noOfDays;
  }
}
