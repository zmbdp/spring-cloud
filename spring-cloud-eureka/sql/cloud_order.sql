-- 创建订单数据库及表
create database if not exists cloud_order charset utf8mb4;

use cloud_order;

drop table if exists order_detail;

create table order_detail
(
    id          int not null auto_increment comment '订单id',
    user_id     bigint(20) not null comment '用户ID',
    product_id  bigint(20) null comment '产品id',
    num         int(10) null default 0 comment '下单数量',
    price       bigint(20) not null comment '实付款',
    delete_flag tinyint(4) null default 0,
    create_time datetime default now(),
    update_time datetime default now(),
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='订单表';

insert into order_detail (user_id, product_id, num, price)
values (2001, 1001, 1, 99),
       (2002, 1002, 1, 30),
       (2001, 1003, 1, 40),
       (2003, 1004, 3, 58),
       (2004, 1005, 7, 85),
       (2005, 1006, 7, 94);

-- 创建产品数据库及表
create database if not exists cloud_product charset utf8mb4;

use cloud_product;

drop table if exists product_detail;

create table product_detail
(
    id            int not null auto_increment comment '产品id',
    product_name  varchar(128) null comment '产品名称',
    product_price bigint(20) not null comment '产品价格',
    state         tinyint(4) null default 0 comment '产品状态 0-有效 1-下架',
    create_time   datetime default now(),
    update_time   datetime default now(),
    primary key (id)
) engine=innodb default charset=utf8mb4 comment='产品表';

insert into product_detail (id, product_name, product_price, state)
values (1001, 'T恤', 101, 0),
       (1002, '短袖', 30, 0),
       (1003, '短裤', 44, 0),
       (1004, '卫衣', 58, 0),
       (1005, '马甲', 98, 0),
       (1006, '羽绒服', 101, 0),
       (1007, '冲锋衣', 30, 0),
       (1008, '袜子', 44, 0),
       (1009, '鞋子', 58, 0),
       (10010, '毛衣', 98, 0);