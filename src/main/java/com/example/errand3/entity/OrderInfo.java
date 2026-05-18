package com.example.errand3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("order_info")
public class OrderInfo {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String orderNo;
    private String goodsName;
    private String description;
    private String goodsImg;
    private String goodsType;
    private BigDecimal goodsWeight;
    private BigDecimal tip;
    private Long senderId;
    private String pickupAddress;    // 取件地址
    private String deliveryAddress;  // 收货地址
    private Long runnerId;
    private String status;
    private String senderContact;
    private String receiverContact;
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private LocalDateTime acceptTime;
}