package com.zmbdp.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductInfo {
    private Integer id;
    private String productName; // 产品名称
    private Integer productPrice; // 产品价格
    private Integer state; // 产品状态：0-有效 1-下架
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间
}
