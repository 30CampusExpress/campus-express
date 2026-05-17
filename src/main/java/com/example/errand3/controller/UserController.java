package com.example.errand3.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.User;
import com.example.errand3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // ==================== 登录 ====================
    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");

        // 查询时显式包含 password 字段
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username)
                .select(User::getId, User::getUsername, User::getPassword, User::getNickname,
                        User::getAvatar, User::getPhone, User::getGender, User::getCreateTime);
        User user = userService.getOne(wrapper);

        if (user == null) {
            return Result.error("账号不存在");
        }
        if (!user.getPassword().equals(password)) {
            return Result.error("密码错误");
        }

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", user.getId());
        userInfo.put("username", user.getUsername());
        userInfo.put("nickname", user.getNickname());
        userInfo.put("gender", user.getGender());
        userInfo.put("role", "USER");
        return Result.success(userInfo);
    }

    // ==================== 分页查询 ====================
    @GetMapping("/list")
    public Result<Page<User>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false) String username,
                                   @RequestParam(required = false) String nickname) {
        Page<User> page = userService.getUserPage(pageNum, pageSize, username, nickname);
        return Result.success(page);
    }

    // ==================== 新增 ====================
    @PostMapping
    public Result<?> add(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    // ==================== 修改 ====================
    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    // ==================== 批量删除 ====================
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        userService.removeBatchByIds(ids);
        return Result.success();
    }

    // 用户注册接口
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        // 强制设置角色为普通用户
        // 调用新增方法保存到数据库
        userService.save(user);
        return Result.success();
    }
}