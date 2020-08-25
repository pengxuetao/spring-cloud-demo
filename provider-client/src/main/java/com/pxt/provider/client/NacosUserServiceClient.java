package com.pxt.provider.client;

import com.pxt.provider.client.hystrix.NacosUserServiceClientHystrixFactory;
import com.pxt.provider.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Peng xue-tao
 * @since 2020/8/13
 */
@FeignClient(name = "nacos-provider", path = "/user", fallbackFactory = NacosUserServiceClientHystrixFactory.class)
public interface NacosUserServiceClient {

    @GetMapping("/user/{id}")
    User queryUser(@PathVariable("id") String id);
}
