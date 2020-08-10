package com.pxt.consumer.controller;

import com.pxt.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Peng xue-tao
 * @since 2020/8/10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public Object queryUser(@PathVariable("id") String id) {
        User result = restTemplate.getForObject("http://127.0.0.1:8085" + "/user/user/1", User.class);
        return result;
    }
}
