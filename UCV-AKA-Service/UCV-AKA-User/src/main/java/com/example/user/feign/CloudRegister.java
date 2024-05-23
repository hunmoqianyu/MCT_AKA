package com.example.user.feign;


import com.example.model.entity.Card;
import com.example.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="UCV-AKA-Cloud",path = "/cloud/userC")
public interface CloudRegister {
    @PostMapping ("/register")
    Card add(User user);

    @PostMapping("/login")
    String login(@RequestBody User user, @RequestParam String e);
}
