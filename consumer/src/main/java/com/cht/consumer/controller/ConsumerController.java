package com.cht.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cht.consumer.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerService service;

	// 指定返回托底数据的函数
	@HystrixCommand(fallbackMethod = "hello")
	@GetMapping("/hello")
	public String sayHello(@RequestParam String name) {
		return service.sayHello(name);
	}

	/**
	 * 托底函数
	 * 
	 * @param username
	 * @return
	 */
	public String hello(String username) {
		return "hello" + username + ";  server exception,please check producter server";
	}

	public String hello(Integer id) {
		return "hello" + id + ";  server exception,please check producter server";
	}

	// =====================演示服务熔断======================
	@GetMapping("/serviceBreaker")
	@HystrixCommand(fallbackMethod = "hello", commandProperties = {
			// 默认20个;10s内请求数大于20个时就启动熔断器，当请求符合熔断条件时将触发getFallback()。
			@HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
			// 请求错误率大于50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发getFallback()。
			@HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50"),
			// 默认5秒;熔断多少秒后去尝试请求
			@HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000"), })
	public String serviceBreaker(@RequestParam Integer id) {
		return service.serviceBreaker(id);
	}

	// =======================线程池隔离示例==============================
	@HystrixCommand(groupKey="consumer", commandKey = "threadPoolSeverance",
		    threadPoolKey="e-book-product", 
		    		threadPoolProperties = {
		            @HystrixProperty(name = "coreSize", value = "30"),//线程池大小
		            @HystrixProperty(name = "maxQueueSize", value = "100"),//最大队列长度
		            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),//线程存活时间
		            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")//拒绝请求
		    },
		    fallbackMethod = "threadPool")
	public String threadPoolSeverance(@RequestParam Integer id) {
		return String.valueOf(id);
	}
	
	//回调函数
	public String threadPool() {
		return "error";
	}
}
