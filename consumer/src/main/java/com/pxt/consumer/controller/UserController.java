package com.pxt.consumer.controller;

import com.pxt.provider.entity.User;
import com.pxt.provider.client.UserServiceClient;
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
    @Resource
    private UserServiceClient userServiceClient;

    @GetMapping("/user/{id}")
    public String queryUser(@PathVariable("id") String id) {
        User result = restTemplate.getForObject("http://provider/user/user/" + id, User.class);
        assert result != null;
        return result.toString();
    }

    @GetMapping("/user/feign/{id}")
    public String queryUserByFeign(@PathVariable("id") String id) {
        User result = userServiceClient.queryUser(id);
        return result.toString();
    }
}
