package com.example.errand3.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.OrderInfo;
import com.example.errand3.entity.Certification;      // 新增引入
import com.example.errand3.service.IOrderInfoService;
import com.example.errand3.service.ICertificationService;  // 新增引入
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderService;

    @Autowired
    private ICertificationService certificationService;  // 新增

    // ================== 分页查询 ==================
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

    // ================== 新增订单 ==================
    @PostMapping
    public Result<?> add(@RequestBody OrderInfo order) {
        orderService.addOrder(order);
        return Result.success();
    }

    // ================== 修改订单（接单） ==================
    @PutMapping
    public Result<?> update(@RequestBody OrderInfo order) {
        // 如果是接单操作（传了 runnerId），需要校验骑手认证状态
        if (order.getRunnerId() != null) {
            // 查询该接单人的认证信息
            LambdaQueryWrapper<Certification> certWrapper = new LambdaQueryWrapper<>();
            certWrapper.eq(Certification::getUserId, order.getRunnerId())
                    .eq(Certification::getStatus, "通过");
            Certification cert = certificationService.getOne(certWrapper);

            // 如果没有通过认证的记录，则拒绝接单
            if (cert == null) {
                return Result.error("您尚未通过骑手认证，无法接单，请先提交认证并通过审核");
            }
        }

        // 正常更新订单
        if (order.getStatus() != null && order.getStatus().equals("已接单")) {
            order.setAcceptTime(LocalDateTime.now());
        }
        orderService.updateById(order);
        return Result.success();
    }

    // ================== 批量删除 ==================
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        orderService.removeBatchByIds(ids);
        return Result.success();
    }
}