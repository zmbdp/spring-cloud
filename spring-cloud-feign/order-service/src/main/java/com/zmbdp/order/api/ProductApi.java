package com.zmbdp.order.api;

import com.zmbdp.order.model.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", path = "/product")
public interface ProductApi {
    @RequestMapping("/getProductById/productId={productId}")
    ProductInfo getProductInfoById(@PathVariable("productId") Integer productId);

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
