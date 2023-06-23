package com.example.repository;

import com.example.model.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Component
@FeignClient(name = "User", url = "localhost:7777")
public interface UserModuleApi {

    @GetMapping("/order/add")
    @ResponseBody OrderDTO addOrder(@RequestParam String title);
}