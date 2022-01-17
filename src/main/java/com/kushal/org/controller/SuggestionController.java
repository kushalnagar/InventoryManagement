package com.kushal.org.controller;

import com.kushal.org.bean.Suggestion;
import com.kushal.org.bean.SuggestionDetail;
import com.kushal.org.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuggestionController {
  @Autowired SuggestionService suggestionService;

  @GetMapping("product/suggestion")
  private List<Suggestion> getSuggestion(){
    return suggestionService.getSuggestion();
  }

  @GetMapping("product/{id}/suggestionDetail")
  private SuggestionDetail getSuggestionDetails(@PathVariable int id){
    return suggestionService.getSuggestionDetails(id);
  }
}
