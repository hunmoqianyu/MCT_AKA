package com.example.vehicle.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.config.GlobalConfig;
import com.example.common.utils.Hash;
import com.example.common.utils.RandomIntegerGenerator;
import com.example.model.common.dtos.ResponseResult;
import com.example.model.entity.SessionKey;
import com.example.model.entity.User;
import com.example.model.entity.VeC;
import com.example.vehicle.feign.CloudSecrect;
import com.example.vehicle.service.SessionKeyService;
import com.example.vehicle.service.VeCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

/**
 * (VeC)表控制层
 *
 * @author makejava
 * @since 2024-05-13 15:03:21
 */
@RestController
@RequestMapping("/vehicle")
@Slf4j
public class VeCController {
    /**
     * 服务对象
     */
    @Resource
    private VeCService veCService;
    @Autowired
    private CloudSecrect cloudSecrect;

    @Resource
    private SessionKeyService sessionKeyService;

    /**
     * 分页查询
     *
     * @param veC 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<VeC>> queryByPage(VeC veC, PageRequest pageRequest) {
        return ResponseEntity.ok(this.veCService.queryByPage(veC, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<VeC> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.veCService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param veC 实体
     * @return 新增结果
     */
    @PostMapping("/register")
    public ResponseResult<VeC> add(@RequestBody VeC veC) {
        log.info(veC.getVid());
        VeC veC1 = veCService.queryById(veC.getVid());
        if(veC1!=null){
            return ResponseResult.okResult("登录成功");
        }
        //远程调用云端获取密钥
        String secret = cloudSecrect.getSecret();
        log.info(secret);
        veC.setVk(secret);
        veCService.insert(veC);
        return ResponseResult.okResult("注册成功");
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) throws NoSuchAlgorithmException {
        String r= String.valueOf(RandomIntegerGenerator.generate());
        String session_key= Hash.hash(user.getUsername()+user.getVid()+r);

        SessionKey key = new SessionKey();
        key.setVid(user.getVid());
        key.setUserId(user.getUsername());
        key.setValue(session_key);
        sessionKeyService.insert(key);
        GlobalConfig.vid=user.getVid();
        return r;
    }

    @GetMapping("/Keyid")
    public Integer getKey(){
        SessionKey maxKeyIdRecord = sessionKeyService.getMaxKeyIdRecord();
        return maxKeyIdRecord.getKeyId();
    }
}

