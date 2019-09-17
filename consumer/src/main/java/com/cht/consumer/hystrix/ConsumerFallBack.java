package com.cht.consumer.hystrix;

import org.springframework.stereotype.Component;

import com.cht.consumer.service.ConsumerService;

@Component
public class ConsumerFallBack implements ConsumerService{

	@Override
	public String sayHello(String name) {
		return "fallback say hello";
	}

	@Override
	public String hello(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String serviceBreaker(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
