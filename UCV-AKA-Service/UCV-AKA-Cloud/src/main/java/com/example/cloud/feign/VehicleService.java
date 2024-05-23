package com.example.cloud.feign;


import com.example.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="UCV-AKA-Vehicle",path = "/vehicle")
public interface VehicleService{
    @PostMapping("/login")
     String getR(User user);
}
