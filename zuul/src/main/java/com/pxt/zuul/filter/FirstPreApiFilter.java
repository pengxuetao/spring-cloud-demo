package com.pxt.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author Peng xue-tao
 * @since 2020/8/20
 */
@Component
public class FirstPreApiFilter extends ZuulFilter {

    /**
     * 过滤类型
     *
     * pre-路由之前 routing-路由之时 post-路由之后 error-发生错误时调用
     * @return String
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤顺序
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("FirstPreApiFilter");
        return null;
    }
}
