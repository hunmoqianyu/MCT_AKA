package com.example.cloud.controller;
import com.example.cloud.feign.VehicleService;
import com.example.cloud.service.UserCService;
import com.example.common.utils.Hash;
import com.example.common.utils.RandomIntegerGenerator;
import com.example.common.utils.UUIDUtils;
import com.example.model.entity.Card;
import com.example.model.entity.User;
import com.example.model.entity.UserC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * (UserC)表控制层
 *
 * @author makejava
 * @since 2024-05-13 20:30:57
 */
@Slf4j
@RestController
@RequestMapping("/cloud/userC")
public class UserCController {
    /**
     * 服务对象
     */
    @Resource
    private UserCService userCService;

    @Autowired
    private VehicleService vehicleService;

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/register")
    public Card add(@RequestBody User user) throws NoSuchAlgorithmException {
        UserC userC =new UserC();
        userC.setUserId(user.getUsername());
        userC.setR(String.valueOf(RandomIntegerGenerator.generate()));
        userC.setPriKeyS(UUIDUtils.generate32LowerKey());
        String pri_a= Hash.hash(userC.getUserId()+userC.getPriKeyS());
        String pri_b=Hash.hash((userC.getUserId()+userC.getR()));
        userC.setParaA(pri_a);
        userC.setParaB(pri_b);
        userCService.insert(userC);
        Card card=new Card();
        card.setCardId(userC.getUserId()+"card");
        card.setParaA(pri_a);
        card.setParaB(pri_b);
        card.setPubKeyS(userC.getPriKeyS());
        return card;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user,@RequestParam String e) throws NoSuchAlgorithmException {
        UserC userC = userCService.queryById(user.getUsername());
        log.info(user.getUsername());
        String e1=Hash.hash(user.getUsername()+userC.getParaA()+userC.getParaB());
        if(!Objects.equals(e, e1)){
            return null;
        }
        String r = vehicleService.getR(user);
        return r;
    }





}

