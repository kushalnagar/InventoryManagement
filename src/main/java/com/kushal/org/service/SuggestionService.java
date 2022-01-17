package com.kushal.org.service;

import com.kushal.org.bean.ProductNode;
import com.kushal.org.bean.ProductOrderQuantity;
import com.kushal.org.model.Inventory;
import com.kushal.org.model.Product;
import com.kushal.org.bean.Suggestion;
import com.kushal.org.bean.SuggestionDetail;
import com.kushal.org.model.ProductFactory;
import com.kushal.org.repository.ProductFactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class SuggestionService {

  private final int THRESHOLD = 0;

  private final String DOMAIN_URL = "http://localhost:8080/";

  @Autowired ProductService productService;

  @Autowired InventoryService inventoryService;

  @Autowired ProductFactoryRepository productFactoryRepository;

  public List<Suggestion> getSuggestion() {
    List<Suggestion> suggestions = new ArrayList<>();
    List<Product> products = getProductsToBeOrdered();
    for(Product product: products) {
      Suggestion suggestion = new Suggestion();
      suggestion.setProduct(product);
      suggestion.setSuggestionURL("/product/"+product.getId()+"/suggestionDetail");
      suggestions.add(suggestion);
    }
    return suggestions;
  }

  public List<Product> getProductsToBeOrdered() {
    List<Product> result = new ArrayList<>();
    List<Product> products = productService.getAllProduct();
    for (Product product : products) {
      int total = 0;
      List<Inventory> inventories = inventoryService.findByProductId(product.getId());
      for (Inventory inventory : inventories) {
        total += inventory.getQuantity();
      }
      if (total <= THRESHOLD) {
        result.add(product);
      }
    }
    return result;
  }

  public SuggestionDetail getSuggestionDetails(int id) {
    SuggestionDetail suggestionDetail = new SuggestionDetail();
    ProductNode root = getProductTree(id);
    HashMap<Integer, Integer> orderProduct = new HashMap<>();
    int noOfDays = dfs(root,orderProduct);
    List<Product> productsToBeOrdered = productService.getAllProductByProductIds(orderProduct.keySet());
    List<ProductOrderQuantity> productToBeOrderedWithQuantity = new ArrayList<>();
    for(Product product: productsToBeOrdered) {
      ProductOrderQuantity productOrderQuantity = new ProductOrderQuantity();
      productOrderQuantity.setId(product.getId());
      productOrderQuantity.setProductName(product.getProductName());
      productOrderQuantity.setQuantity(orderProduct.get(product.getId()));
      productToBeOrderedWithQuantity.add(productOrderQuantity);
    }
    suggestionDetail.setProductToBeOrdered(productToBeOrderedWithQuantity);
    suggestionDetail.setNoOfDays(noOfDays);
    return suggestionDetail;
  }

  public int dfs(ProductNode node, HashMap<Integer, Integer> orderProduct){
    if(node.getRawProduct().isEmpty()){
      orderProduct.put(node.getId(), orderProduct.getOrDefault(node.getId(),0)+1);
      return node.getNoOfDays();
    }

    int max_no_of_days = 0;
    for(ProductNode eachNode : node.getRawProduct()){
      max_no_of_days = Math.max(max_no_of_days, dfs(eachNode, orderProduct));
    }

    return node.getNoOfDays() + max_no_of_days;

  }

  private ProductNode getProductTree(int id) {
    HashMap<Integer, ProductNode> productNodeMap = new HashMap<>();
    HashMap<Integer, Integer> productNoOfDaysMap = new HashMap<>();
    ProductNode root = new ProductNode(id);
    productNodeMap.put(id, root);
    Queue<Integer> productQueue = new LinkedList<>();
    productQueue.add(id);
    while(!productQueue.isEmpty()){
      int product = productQueue.poll();
      ProductNode node = productNodeMap.get(product);
      ProductFactory productFactory = productFactoryRepository.findByProduct(product);
      node.setNoOfDays(productFactory.getNoOfDays());
      if(!productFactory.getRawProductList().isEmpty()){
        for(Integer prod: productFactory.getRawProductList()){
          ProductNode newNode = new ProductNode(prod);
          node.getRawProduct().add(newNode);
          productNodeMap.put(prod, newNode);
          productQueue.add(prod);
        }
      }
    }

    return root;
  }
}
