package com.zmbdp.product.service;

import com.zmbdp.product.mapper.ProductMapper;
import com.zmbdp.product.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public ProductInfo selectOrderById(Integer productId) {
        return productMapper.selectProductById(productId);
    }
}
