package com.example.errand3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.OrderInfo;
import com.example.errand3.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderService;

    /**
     * 分页查询订单列表
     * GET /api/order/list?pageNum=1&pageSize=10&orderNo=xxx&goodsName=咖啡&status=已发布&senderId=1
     */
    @GetMapping("/list")
    public Result<Page<OrderInfo>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(required = false) String orderNo,
                                        @RequestParam(required = false) String goodsName,
                                        @RequestParam(required = false) String status,
                                        @RequestParam(required = false) Long senderId) {
        Page<OrderInfo> page = orderService.getOrderPage(pageNum, pageSize,
                orderNo, goodsName, status, senderId);
        return Result.success(page);
    }

    /**
     * 新增订单
     * POST /api/order
     */
    @PostMapping
    public Result<?> add(@RequestBody OrderInfo order) {
        orderService.addOrder(order);
        return Result.success();
    }

    /**
     * 修改订单（接单、修改状态等）
     * PUT /api/order
     */
    @PutMapping
    public Result<?> update(@RequestBody OrderInfo order) {
        orderService.updateById(order);
        return Result.success();
    }

    /**
     * 批量删除订单
     * DELETE /api/order/1,2,3
     */
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        orderService.removeBatchByIds(ids);
        return Result.success();
    }
}