package com.example.errand3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("certification")
public class Certification {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;
    private String realName;
    private String photo;
    private String contact;
    private String idCard;
    private String idCardFront;
    private String idCardBack;
    private String address;
    private String status;
    private String reason;
}