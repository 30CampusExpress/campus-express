package com.example.errand3.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.errand3.entity.Admin;
import com.example.errand3.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public Page<Admin> getAdminPage(int pageNum, int pageSize, String username, String nickname) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();

        // 模糊搜索
        wrapper.like(StringUtils.hasText(username), Admin::getUsername, username);
        wrapper.like(StringUtils.hasText(nickname), Admin::getNickname, nickname);
        // 按创建时间倒序
        wrapper.orderByDesc(Admin::getCreateTime);

        Page<Admin> page = new Page<>(pageNum, pageSize);
        return this.page(page, wrapper);
    }
}