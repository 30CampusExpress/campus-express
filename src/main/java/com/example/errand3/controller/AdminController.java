package com.example.errand3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.Admin;
import com.example.errand3.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /**
     * 分页查询管理员列表
     * GET /api/admin/list?pageNum=1&pageSize=10&username=xxx
     */
    @GetMapping("/list")
    public Result<Page<Admin>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(required = false) String username,
                                    @RequestParam(required = false) String nickname) {
        Page<Admin> page = adminService.getAdminPage(pageNum, pageSize, username, nickname);
        return Result.success(page);
    }

    /**
     * 新增管理员
     * POST /api/admin
     * Body: { "username": "admin2", "password": "123", ... }
     */
    @PostMapping
    public Result<?> add(@RequestBody Admin admin) {
        adminService.save(admin);
        return Result.success();
    }

    /**
     * 修改管理员
     * PUT /api/admin
     */
    @PutMapping
    public Result<?> update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.success();
    }

    /**
     * 批量删除管理员
     * DELETE /api/admin/1,2,3
     */
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        adminService.removeBatchByIds(ids);
        return Result.success();
    }
}