package com.pxt.provider.client.hystrix;

import com.pxt.provider.client.UserServiceClient;
import com.pxt.provider.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Peng xue-tao
 * @since 2020/8/13
 */
@Component
public class UserServiceClientHystrixFactory implements FallbackFactory<UserServiceClient> {

    @Override
    public UserServiceClient create(Throwable throwable) {
        return id -> {
            User user = new User();
            user.setId(id);
            user.setUserName("qwer");
            user.setAddress(id+"factory降级");
            return user;
        };
    }
}
