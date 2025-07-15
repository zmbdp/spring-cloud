package com.zmbdp.order.service;

import com.zmbdp.order.mapper.OrderMapper;
import com.zmbdp.order.model.OrderInfo;
import com.zmbdp.order.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public OrderInfo selectOrderById(Integer orderId) {
        // 先拿到这个值
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);
        String url = "http://127.0.0.1:9090/product/getProductById/productId=" + orderInfo.getProductId();
        // 通过 restTemplate 使用 HTTP 调用获取商品详情的接口（根据商品ID），然后放到 orderInfo 中
        ProductInfo productInfo = restTemplate.getForObject(url, ProductInfo.class);
        orderInfo.setProductInfo(productInfo);
        return orderInfo;

    }
}
