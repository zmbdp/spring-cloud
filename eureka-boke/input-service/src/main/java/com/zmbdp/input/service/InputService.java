package com.zmbdp.input.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class InputService {

//    String[] ports = new String[]{"9090", "9091", "9092"};

    private AtomicInteger index = new AtomicInteger(0);

    private List<ServiceInstance> instances;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient; // 拿到 eureka 注册中心的类

    @PostConstruct
    public void init() {
        // 从 Eureka 中获取指定服务的服务列表
        instances = discoveryClient.getInstances("output-service");
    }

    /*public String setValue(String value) {
        // 先拼接好要发送给 output 的 url，采用轮询的方式
        String url = "http://127.0.0.1:" +
                ports[index.getAndIncrement() % ports.length] + // 选择一个端口，直接用轮询的办法
                "/output/getValue/" + value;

        log.info("远程调用 url：{}", url);

        // 通过 restTemplate 使用 HTTP 调用此 url，然后他就会调用 output 程序
        return restTemplate.getForObject(url, String.class);
    }*/


    public String setValue(String value) {
        // 首先得从 eureka 中获取到这个服务的 uri
        int subscript = index.getAndIncrement() % instances.size(); // instances.size(): 获取这个服务有几个端口
//        String uri = instances.get(subscript).getUri().toString();
        // 然后再拼接 url
//        String url = uri + "/output/getValue/" + value;

        // Eureka 会自动判断 output-service 是多少
        String url = "http://output-service/output/getValue/" + value;
        // 打印看一下
        log.info("远程调用 url：{}", url);
        return  restTemplate.getForObject(url, String.class);
    }
}
