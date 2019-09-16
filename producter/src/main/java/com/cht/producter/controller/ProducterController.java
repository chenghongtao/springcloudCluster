package com.cht.producter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/producter")
public class ProducterController {

	@GetMapping("/hello")
	public String sayHello(@RequestParam String name, HttpServletRequest request) {
		System.out.println(request.getLocalPort() + ":" + request.getLocalAddr());
		return name + ", hello  " + request.toString();
	}

	@GetMapping("/serviceBreaker")
	public String serviceBreaker(Integer id) {
		if (id == 1) {
			throw new RuntimeException();
		}
		return id + " serviceBreaker sucess";
	}
}
