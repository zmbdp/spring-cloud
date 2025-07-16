package com.zmbdp.product.controller;

import com.zmbdp.product.model.ProductInfo;
import com.zmbdp.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getProductById/productId={productId}")
    public ProductInfo getProductById(@PathVariable("productId") Integer productId){
        log.info("查询商品信息，商品ID：{}", productId);
        return productService.selectOrderById(productId);
    }

    @RequestMapping("/str")
    public String p1(@RequestParam("str") String str){
        log.info("str：{}", str);
        return str;
    }

    @RequestMapping("/in")
    public int p2(@RequestParam("in") Integer in){
        log.info("in：{}", in);
        return in;
    }

    @RequestMapping("/duoGe")
    public String duoGe(@RequestParam("str") String str, @RequestParam("in") Integer in){
        log.info("str：{}; in: {}", str, in);
        return "str: " + str + "; in: " + in + ";";
    }

    @RequestMapping("/duiXiang") // url: http://127.0.0.1:9090/product/duiXiang?id=1&productName=zmbdp&productPrice=123&state=1
    public String duiXiang(ProductInfo productInfo){
        log.info("productId：{}", productInfo.toString());
        return productInfo.toString();
    }

    @RequestMapping("/jianSen") // url: http://127.0.0.1:9090/product/jianSen body: {"id":1,"productName":"zmbdp","productPrice":123,"state":1"}
    public String jianSen(@RequestBody ProductInfo productInfo){
        log.info("productId：{}", productInfo.toString());
        return productInfo.toString();
    }
}
