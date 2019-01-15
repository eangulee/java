// tag::baseClass[]
package com.eangulee.springbootdemo.controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
//end::baseClass[]
import org.springframework.web.bind.annotation.PostMapping;
//tag::baseClass[]
import org.springframework.web.bind.annotation.RequestMapping;

import com.eangulee.springbootdemo.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
  
//end::baseClass[]
//tag::orderForm[]
  @GetMapping("/current")
  public String orderForm(Model model) {
    model.addAttribute("order", new Order());
    model.addAttribute("userName","eangulee");
    return "orderForm";
  }
//end::orderForm[]

/*
//tag::handlePost[]
  @PostMapping
  public String processOrder(Order order) {
    log.info("Order submitted: " + order);
    return "redirect:/";
  }
//end::handlePost[]
*/
  
//tag::handlePostWithValidation[]
  @PostMapping
  public String processOrder(@Valid Order order, Errors errors) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    
    log.info("Order submitted: " + order);
    return "redirect:/";
  }
//end::handlePostWithValidation[]
  
//tag::baseClass[]
  
}
//end::baseClass[]
