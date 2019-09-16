package com.cht.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cht.consumer.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerService service;
    
	//指定返回托底数据的函数
	@HystrixCommand(fallbackMethod = "hello")
	@GetMapping("/hello")
	public String sayHello(@RequestParam String name) {
		return service.sayHello(name);
	}
    
	/**
	 * 托底函数
	 * @param username
	 * @return
	 */
	public String hello(String username) {
		return "hello"+username+";  server exception,please check producter server";
	}

}
