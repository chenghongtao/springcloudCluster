package com.cht.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@FeignClient(name="producter",url = "http://slave1:10012/")
@Service
public interface ConsumerService {
    @GetMapping("/producter/hello")
    String sayHello(@RequestParam(value = "name") String name);

}
