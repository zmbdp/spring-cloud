package com.zmbdp.order.model;

import com.zmbdp.product.model.ProductInfo;
import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    private Integer id;
    private Integer userId; // 用户 id
    private Integer productId; // 产品 id
    private Integer num; // 下单数量
    private Integer price; // 实付款
    private Integer deleteFlag; // 删除键
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间
    private ProductInfo productInfo; // 商品信息
}
