package com.cht.consumer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cht.consumer.service.ConsumerService;

import feign.hystrix.FallbackFactory;

public class ConsumerServiceFallBackFactory implements FallbackFactory<ConsumerService> {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceFallBackFactory.class);

	@Override
	public ConsumerService create(Throwable cause) {
		return new ConsumerService() {

			@Override
			public String sayHello(String name) {
				logger.error("say hello throw exception",cause);
				return null;
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
			
		};
	}

}
