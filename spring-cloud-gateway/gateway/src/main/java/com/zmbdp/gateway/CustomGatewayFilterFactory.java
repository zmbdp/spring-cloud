package com.zmbdp.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
// 单个过滤器，需要的就要自行配置
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomConfig> implements Ordered {

    public CustomGatewayFilterFactory() {
        // 告诉父类，我传递的是这样一个参数
        super(CustomConfig.class);
    }

    @Override
    public GatewayFilter apply(CustomConfig config) {
        return new GatewayFilter() {
            /**
             * 过滤逻辑
             * ServerWebExchange: HTTP 请求 - 响应 交互契约, 提供了请求和响应的访问，
             *                    类似于 Request 和 Response 的组合对象, 里面有 getRequest() getResponse() getSession() 等方法
             * GatewayFilterChain: 过滤器链对象，用于调用下一个过滤器
             * Mono： 响应对象，类似于 Java 8 中的 Optional，是 Reactor 中的一个核心概念
             * @param exchange 请求对象，大白话就是 异步完成一件事情，但是不返回任何结果，比如异步调用一个方法，但是不返回结果
             * @param chain 过滤器链对象
             * @return 响应对象
             */
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 过滤器执行顺序: pre类型 -> custom(执行请求) -> post类型
                // 在执行请求之前打印一个日志
                log.info("Pre Gateway Filter：custom filter: {}", config.toString());
                // 继续调用下一个过滤器
                return chain.filter(exchange)
                        // 在执行完成请求后做的事情就是 Mono 的
                        .then(Mono.fromRunnable(() -> {
                            log.info("Post Gateway Filter....."); // Post 类型执行的逻辑
                        }));
            }
        };
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
