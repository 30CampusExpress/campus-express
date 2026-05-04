package com.example.errand3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.errand3.entity.Admin;

public interface IAdminService extends IService<Admin> {

    /**
     * 分页查询管理员（可按账号、姓名模糊搜索）
     */
    Page<Admin> getAdminPage(int pageNum, int pageSize, String username, String nickname);
}