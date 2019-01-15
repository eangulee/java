package com.eangulee.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String home() {
		log.info("home test!");
		return "home";
	}
	
//	@GetMapping(value = "/index")
//	public String index() {
//		return "index";
//	}
}
