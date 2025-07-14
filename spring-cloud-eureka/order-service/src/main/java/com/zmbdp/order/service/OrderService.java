package com.zmbdp.order.service;

import com.zmbdp.order.mapper.OrderMapper;
import com.zmbdp.order.model.OrderInfo;
import com.zmbdp.order.model.ProductInfo;
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
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    private List<ServiceInstance> instances;

    @PostConstruct
    public void init() {
        // 从 Eureka 中获取服务列表
        instances = discoveryClient.getInstances("product-service");
    }


    // 计数器
    private AtomicInteger count = new AtomicInteger(1);

    /*public OrderInfo selectOrderById(Integer orderId) {
        // 先拿到这个值
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
//        String url = "http://127.0.0.1:9090/product/getProductById?productId=" + orderInfo.getProductId();

        // 从 Eureka 中获取服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCT-SERVICE");
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        // 再获取它的 uri 就是前面 http+ip+端口号 这一坨
        String uri = instances.get(0).getUri().toString();
        String url = uri + "/product/getProductById?productId=" + orderInfo.getProductId();

        // 打印看一下
        log.info("远程调用 url：{}", url);

        // 通过 restTemplate 使用 HTTP 调用获取商品详情的接口（根据商品ID），然后放到 orderInfo 中
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;

    }*/

    /*public OrderInfo selectOrderById(Integer orderId) {
        // 先拿到这个值
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
//        String url = "http://127.0.0.1:9090/product/getProductById?productId=" + orderInfo.getProductId();

        // 每次轮流请求服务器    instances: 服务器列表
        int index = count.getAndIncrement() % instances.size(); // getAndIncrement 取值 + 1 操作

        // 再获取它的 uri 就是前面 http+ip+端口号 这一坨
        String uri = instances.get(index).getUri().toString();
        String url = uri + "/product/getProductById?productId=" + orderInfo.getProductId();

        // 打印看一下
        log.info("远程调用 url：{}", url);

        // 通过 restTemplate 使用 HTTP 调用获取商品详情的接口（根据商品ID），然后放到 orderInfo 中
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;

    }*/

    public OrderInfo selectOrderById(Integer orderId) {
        // 先拿到这个值
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
        String url = "http://product-service/product/getProductById?productId=" + orderInfo.getProductId();

        // 打印看一下
        log.info("远程调用 url：{}", url);

        // 通过 restTemplate 使用 HTTP 调用获取商品详情的接口（根据商品ID），然后放到 orderInfo 中
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;

    }
}
