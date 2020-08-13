package com.pxt.provider.controller;

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

    @GetMapping("/user/{id}")
    public User queryUser(@PathVariable("id") String id) {
        User user = new User();
        user.setAddress("provider2");
        if ("1".equals(id)) {
            user.setId("1");
            user.setUserName("一一一");
        } else {
            user.setId("999");
            user.setUserName("九九九");
        }
        return user;
    }
}
