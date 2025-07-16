package com.zmbdp.product.api;

import com.zmbdp.product.model.ProductInfo;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductInterface {

    @RequestMapping("/getProductById/productId={productId}")
    ProductInfo getProductById(@PathVariable("productId") Integer productId);

    @RequestMapping("/str")
    String p1(@RequestParam("str") String str);

    @RequestMapping("/in")
    int p2(@RequestParam("in") Integer in);

    @RequestMapping("/duoGe")
    String duoGe(@RequestParam("str") String str, @RequestParam("in") Integer in);

    @RequestMapping("/duiXiang")
    String duiXiang(@SpringQueryMap ProductInfo productInfo);// 传递对象用 @SpringQueryMap

    @RequestMapping("/jianSen")
    String jianSen(@RequestBody ProductInfo productInfo);
}
