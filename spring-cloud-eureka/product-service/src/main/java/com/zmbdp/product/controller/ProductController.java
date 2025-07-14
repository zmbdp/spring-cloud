package com.zmbdp.product.controller;

import com.zmbdp.product.model.ProductInfo;
import com.zmbdp.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getProductById")
    public ProductInfo getProductById(@RequestParam("productId") Integer productId) {
        log.info("接收到参数 productId: {}", productId);
        return productService.selectOrderById(productId);
    }
}
