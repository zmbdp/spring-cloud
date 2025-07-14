package com.zmbdp.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(name = "product-service", configuration = CustomLoadBalancerConfiguration.class) // 配置负载均衡策略, name-> 对哪个服务端生效；configuration-> 负载均衡策略是什么
public class BeanConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
