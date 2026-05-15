package com.example.errand3.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("notice")
public class Notice {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;
    private String content;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String creator;
}