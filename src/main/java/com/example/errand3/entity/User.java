package com.example.errand3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("user")             // 对应你的 user 表
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    @TableField(select = false)   // 查数据时不返回密码
    private String password;

    private String nickname;
    private String avatar;
    private String phone;
    private Integer gender;       // 0未知, 1男, 2女

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}