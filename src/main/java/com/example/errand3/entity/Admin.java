package com.example.errand3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("admin")          // 对应你的 admin 表
public class Admin {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    @TableField(select = false)
    private String password;

    private String nickname;
    private String avatar;
    private String phone;
    private String email;
    private String role;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}