package com.example.cloud.controller;


import com.alibaba.nacos.common.utils.UuidUtils;
import com.example.common.utils.UUIDUtils;
import com.example.model.common.dtos.ResponseResult;
import com.example.model.entity.User;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/cloud/api1")
public class ApiController {

    @GetMapping("/getSeK")
    public String getSecret(){
        String key = UUIDUtils.generate32LowerKey();
        return key;
    }
}
