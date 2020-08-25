package com.pxt.provider.client.hystrix;

import com.pxt.provider.client.UserServiceClient;
import com.pxt.provider.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Peng xue-tao
 * @since 2020/8/13
 */
@Component
public class UserServiceClientHystrix implements UserServiceClient {

    @Override
    public User queryUser(String id) {
        User user = new User();
        user.setId(id);
        user.setUserName("qwer");
        user.setAddress(id+"降级");
        return user;
    }
}
