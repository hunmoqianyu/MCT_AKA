package com.example.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="UCV-AKA-Vehicle",path = "/vehicle")
public interface VehicleKeyID{
     @GetMapping("/Keyid")
    public Integer getKeyId();
}
