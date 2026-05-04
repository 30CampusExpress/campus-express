package com.example.errand3.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.errand3.entity.User;
import com.example.errand3.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Page<User> getUserPage(int pageNum, int pageSize, String username, String nickname) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        wrapper.like(StringUtils.hasText(username), User::getUsername, username);
        wrapper.like(StringUtils.hasText(nickname), User::getNickname, nickname);
        wrapper.orderByDesc(User::getCreateTime);

        Page<User> page = new Page<>(pageNum, pageSize);
        return this.page(page, wrapper);
    }
}