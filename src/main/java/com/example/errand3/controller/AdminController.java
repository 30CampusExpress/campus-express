package com.example.errand3.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.Admin;
import com.example.errand3.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    // ==================== 登录 ====================
    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");

        // 查询时显式包含 password 字段
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, username)
                .select(Admin::getId, Admin::getUsername, Admin::getPassword, Admin::getNickname,
                        Admin::getAvatar, Admin::getPhone, Admin::getEmail, Admin::getRole,
                        Admin::getCreateTime);
        Admin admin = adminService.getOne(wrapper);

        if (admin == null) {
            return Result.error("账号不存在");
        }
        if (!admin.getPassword().equals(password)) {
            return Result.error("密码错误");
        }

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", admin.getId());
        userInfo.put("username", admin.getUsername());
        userInfo.put("nickname", admin.getNickname());
        userInfo.put("role", admin.getRole());
        return Result.success(userInfo);
    }

    // ==================== 分页查询 ====================
    @GetMapping("/list")
    public Result<Page<Admin>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(required = false) String username,
                                    @RequestParam(required = false) String nickname) {
        Page<Admin> page = adminService.getAdminPage(pageNum, pageSize, username, nickname);
        return Result.success(page);
    }

    // ==================== 新增 ====================
    @PostMapping
    public Result<?> add(@RequestBody Admin admin) {
        adminService.save(admin);
        return Result.success();
    }

    // ==================== 修改 ====================
    @PutMapping
    public Result<?> update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.success();
    }

    // ==================== 批量删除 ====================
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        adminService.removeBatchByIds(ids);
        return Result.success();
    }
}