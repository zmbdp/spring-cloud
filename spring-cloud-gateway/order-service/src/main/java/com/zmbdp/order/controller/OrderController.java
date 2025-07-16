package com.zmbdp.order.controller;

import com.zmbdp.order.model.OrderInfo;
import com.zmbdp.model.ProductInfo;
import com.zmbdp.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrderById/orderId={orderId}") // url: http://127.0.0.1:8080/order/getOrderById?orderId=1
    public OrderInfo getOrderById(@PathVariable("orderId") Integer orderId){
        return orderService.selectOrderById(orderId);
    }

    @RequestMapping("/getStr")
    public String getP1(@RequestParam("str") String str){
        return orderService.p1(str);
    }

    @RequestMapping("/getIn")
    public int getP2(@RequestParam("in") Integer in){
        return orderService.p2(in);
    }

    @RequestMapping("/getDuoGe") // url: http://127.0.0.1:8080/order/getDuoGe?str=zmbdp&in=123
    public String getDuoGe(@RequestParam("str") String str, @RequestParam("in") Integer in){
        return orderService.duoGe(str, in);
    }

    @RequestMapping("/getDuiXiang") // url: http://127.0.0.1:8080/order/getDuiXiang?id=1&productName=zmbdp&productPrice=123&state=1
    public String getDuiXiang(ProductInfo productInfo){
        return orderService.duiXiang(productInfo);
    }

    @RequestMapping("/getJianSen") // url: http://127.0.0.1:8080/order/getJianSen body: {"id":1,"productName":"zmbdp","productPrice":123,"state":1}
    public String getJianSen(@RequestBody ProductInfo productInfo){
        return orderService.jianSen(productInfo);
    }
}
