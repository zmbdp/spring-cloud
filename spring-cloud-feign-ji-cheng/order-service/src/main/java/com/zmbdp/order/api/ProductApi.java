package com.zmbdp.order.api;

import com.zmbdp.product.api.ProductInterface;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product-service", path = "/product")
public interface ProductApi extends ProductInterface {
}
