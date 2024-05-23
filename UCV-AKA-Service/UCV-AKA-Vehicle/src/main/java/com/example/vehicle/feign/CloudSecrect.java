package com.example.vehicle.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name="UCV-AKA-Cloud",path = "/cloud/api1")
public interface CloudSecrect {
    @GetMapping("/getSeK")
     String getSecret();
}
