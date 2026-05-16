package com.example.errand3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.errand3.entity.User;

public interface IUserService extends IService<User> {

    Page<User> getUserPage(int pageNum, int pageSize, String username, String nickname);
}