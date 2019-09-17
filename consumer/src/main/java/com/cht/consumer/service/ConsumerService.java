package com.cht.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cht.consumer.hystrix.ConsumerFallBack;

@FeignClient(name = "producter", url = "http://slave1:10012/", 
fallback = ConsumerFallBack.class)
@Service
//@CacheConfig(cacheNames = {"com.cht.test"})
public interface ConsumerService {

	@GetMapping(value = "/producter/hello")
	String sayHello(@RequestParam("name") String name);

	// @Cacheable(key="#p0")
	@GetMapping(value = "/producter/hello")
	String hello(String id);

	@GetMapping(value = "/producter/serviceBreaker")
	String serviceBreaker(@RequestParam("id") Integer id);
}
