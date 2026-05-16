package com.example.errand3.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.errand3.entity.Notice;
import com.example.errand3.mapper.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
        implements INoticeService {

    @Override
    public Page<Notice> getNoticePage(int pageNum, int pageSize, String title) {
        LambdaQueryWrapper<Notice> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(title), Notice::getTitle, title);
        wrapper.orderByDesc(Notice::getCreateTime);
        return this.page(new Page<>(pageNum, pageSize), wrapper);
    }
}