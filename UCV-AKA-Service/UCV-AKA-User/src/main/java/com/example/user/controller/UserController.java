package com.example.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.config.GlobalConfig;
import com.example.common.utils.Hash;
import com.example.model.common.dtos.ResponseResult;
import com.example.model.entity.Card;
import com.example.model.entity.Message;
import com.example.model.entity.User;
import com.example.user.feign.CloudRegister;
import com.example.user.feign.VehicleKeyID;
import com.example.user.service.CardService;
import com.example.user.service.MessageService;
import com.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.example.model.common.enums.AppHttpCodeEnum.USER_NOT_REGISTER;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-05-13 10:21:29
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Autowired
    private CloudRegister cloudRegister;
    @Autowired
    private CardService cardService;

    @Autowired
    private MessageService messageService;
    @Autowired
    private VehicleKeyID vehicleKeyID;
    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param username 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryByUsername(@PathVariable("id") String username) {
        return ResponseEntity.ok(userService.queryByUserName(username));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/register")
    public ResponseEntity<String> add(@RequestBody User user) throws NoSuchAlgorithmException {
        Card card = cloudRegister.add(user);
        String pri_c= Hash.hash(user.getUsername()+user.getBio()+user.getPassword());
        card.setTp(user.getBio());
        card.setParaC(pri_c);
        user.setCardId(card.getCardId());
        userService.insert(user);
        cardService.save(card);
        return ResponseEntity.ok("注册成功");
    }

    @PostMapping("/login")
    public ResponseResult<String>login(@RequestBody User user) throws NoSuchAlgorithmException {
        String pri_c= Hash.hash(user.getUsername()+user.getBio()+user.getPassword());
        Card card = cardService.getOne(new LambdaQueryWrapper<Card>().eq(Card::getCardId, user.getUsername() + "card"));
        User user1=userService.queryByUserName(user.getUsername());
        log.info(pri_c);
        if(card==null){
            return ResponseResult.errorResult(USER_NOT_REGISTER);
        }
        if(!Objects.equals(pri_c, card.getParaC())){
            return ResponseResult.errorResult(3,"用户端第一次验证未通过");
        }
        String e=Hash.hash(user.getUsername()+card.getParaA()+card.getParaB());
        String r = cloudRegister.login(user1, e);
        GlobalConfig.username=user.getUsername();
        return ResponseResult.okResult("登陆成功");
    }

    @PostMapping("/send")
    public ResponseResult<String> send(@RequestBody Message message){
        message.setDate(new Date());
        Integer keyId = vehicleKeyID.getKeyId();
        message.setKeyId(keyId);
        messageService.save(message);
        return ResponseResult.okResult("数据发送成功");
    }

    @GetMapping("/get_message")
    public ResponseResult<List<Message>> getList(){
        Integer keyId = vehicleKeyID.getKeyId();
        List<Message> list = messageService.list(new LambdaQueryWrapper<Message>().eq(Message::getKeyId, keyId));
        return ResponseResult.okResult(list);
    }

}

