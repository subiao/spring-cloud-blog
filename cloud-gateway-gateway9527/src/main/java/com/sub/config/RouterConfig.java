package com.sub.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author sub
 * @Date 2021/6/6 10:06
 * @Version 1.0
 * 通过硬编码的方式实现路由转发
 */
@Configuration
public class RouterConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes =builder.routes();

        routes.route("sub.route",r->r.path("/guonei").uri("http://news.baidu.com")).build();

        return  routes.build();
    }
}
