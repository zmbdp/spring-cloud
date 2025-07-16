package com.zmbdp.order.controller;

import com.zmbdp.order.model.OrderInfo;
import com.zmbdp.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrderById/orderId={orderId}")
    public OrderInfo getOrderById(@PathVariable("orderId") Integer orderId){
        return orderService.selectOrderById(orderId);
    }
}
