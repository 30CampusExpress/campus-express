package com.example.errand3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.User;
import com.example.errand3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 分页查询用户列表
     * GET /api/user/list?pageNum=1&pageSize=10
     */
    @GetMapping("/list")
    public Result<Page<User>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(required = false) String username,
                                   @RequestParam(required = false) String nickname) {
        Page<User> page = userService.getUserPage(pageNum, pageSize, username, nickname);
        return Result.success(page);
    }

    /**
     * 新增用户
     * POST /api/user
     */
    @PostMapping
    public Result<?> add(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 修改用户
     * PUT /api/user
     */
    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 批量删除用户
     * DELETE /api/user/1,2,3
     */
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        userService.removeBatchByIds(ids);
        return Result.success();
    }
}