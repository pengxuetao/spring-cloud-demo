package com.pxt.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pxt.provider.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peng xue-tao
 * @since 2020/8/10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @HystrixCommand(fallbackMethod = "queryUserException")
    @GetMapping("/user/{id}")
    public User queryUser(@PathVariable("id") String id) throws Exception {
        User user = new User();
        user.setAddress("provider3");
        if ("1".equals(id)) {
            user.setId("1");
            user.setUserName("一一一");
        } else {
            user.setId("999");
            user.setUserName("九九九");
        }
        if (user == null) {
            throw new Exception("exception");
        }
        return user;
    }

    public User queryUserException(String id) {
        User user = new User();
        user.setAddress("provider1");
        user.setId("error");
        user.setUserName("exception");
        return user;
    }
}
