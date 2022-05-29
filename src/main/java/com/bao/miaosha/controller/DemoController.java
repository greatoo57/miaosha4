package com.bao.miaosha.controller;

import com.bao.miaosha.domain.User;
import com.bao.miaosha.rabbitmq.MQSender;
import com.bao.miaosha.redis.RedisService;
import com.bao.miaosha.redis.UserKey;
import com.bao.miaosha.result.CodeMsg;
import com.bao.miaosha.result.Result;
import com.bao.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;


@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @Autowired
    MQSender sender;

    @Autowired(required = false)
    JedisPool jedisPool;


    @RequestMapping("/mq")
    @ResponseBody
    public Result<String> mq(){
        sender.send("a");
        return Result.success("猪溢心2");
    }





    @RequestMapping("/eat")
    @ResponseBody
    String play(){
        return "1234";
    }

    @RequestMapping("/eat1")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("猪溢心");
    }

    @RequestMapping("/eat2")
    @ResponseBody
    public Result<String> hello2(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/111")
    @ResponseBody
    public String thymeleaf(Model model){
        model.addAttribute("name","猪溢心");
        return "hello";
    }

    @RequestMapping("/db")
    @ResponseBody
    public Result<User> dbGet(){
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/tx")
    @ResponseBody
    public Result<Boolean> Tx(){
        userService.tx();
        return Result.success(true);
    }
    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User  user  = redisService.get(UserKey.getById, "猪溢心"+1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user  = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, ""+1, user);//UserKey:id1
        return Result.success(true);
    }

    @RequestMapping("/redis")
    @ResponseBody
    public Result<User> resultget(){
        redisService.set(UserKey.getById, "key1", "猪溢心老母猪");//UserKey:id1
        User  user1  = redisService.get(UserKey.getById, "key1", User.class);
        return Result.success(user1);
    }
}
