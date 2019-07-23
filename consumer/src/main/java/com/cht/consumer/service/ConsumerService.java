package com.cht.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="producter")
@Service
public interface ConsumerService {
    @GetMapping("/producter/hello")
    String sayHello(@RequestParam(value = "name") String name);
}
