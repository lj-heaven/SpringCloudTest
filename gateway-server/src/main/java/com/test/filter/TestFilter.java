package com.test.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class TestFilter implements GlobalFilter, Ordered {
    //需要实现拦截没有携带指定请求参数的请求
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //先获取ServerHttpRequest对象，注意不是HttpServletRequest
        ServerHttpRequest request = exchange.getRequest();
        //打印所有请求参数
        System.out.println(request.getQueryParams());
        //判断是否包含test参数，且参数值为1
        List<String> value = request.getQueryParams().get("test");
        if(value != null && value.contains("1")){
            //将ServerWebExchange向过滤链的下一级传递
            return chain.filter(exchange);
        }else {
            //不向下传递，返回响应
            return exchange.getResponse().setComplete();
        }
    }

    //order值越小优先级越高，当值一样的时候，全局优于单独路由过滤器，单个路由过滤器的order值从上往下的顺序从1开始递增
    @Override
    public int getOrder() {
        return 0;
    }
}
