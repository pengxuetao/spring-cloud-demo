package com.pxt.consumer.controller;

import com.pxt.provider.client.NacosUserServiceClient;
import com.pxt.provider.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private NacosUserServiceClient nacosUserServiceClient;

    @GetMapping("/user/{id}")
    public String queryUser(@PathVariable("id") String id) {
        LOGGER.info("执行queryUser");
        User result = restTemplate.getForObject("http://nacos-provider/user/user/" + id, User.class);
        assert result != null;
        return result.toString();
    }

    @GetMapping("/user/feign/{id}")
    public String queryUserByFeign(@PathVariable("id") String id) {
        LOGGER.info("执行queryUserByFeign");
        User result = nacosUserServiceClient.queryUser(id);
        return result.toString();
    }
}
