package com.zmbdp.product.controller;

import com.zmbdp.product.model.ProductInfo;
import com.zmbdp.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getProductById/productId={productId}")
    public ProductInfo getProductById(@PathVariable("productId") Integer productId){
        return productService.selectOrderById(productId);
    }
}
