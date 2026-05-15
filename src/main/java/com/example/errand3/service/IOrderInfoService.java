package com.example.errand3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.errand3.entity.OrderInfo;

public interface IOrderInfoService extends IService<OrderInfo> {

    /**
     * 分页查询订单
     * @param pageNum  当前页
     * @param pageSize 每页条数
     * @param orderNo  订单编号（可选，模糊搜索）
     * @param goodsName 物品名称（可选，模糊搜索）
     * @param status   订单状态（可选，精确匹配）
     * @param senderId 发起人ID（可选，精确匹配）
     */
    Page<OrderInfo> getOrderPage(int pageNum, int pageSize,
                                 String orderNo, String goodsName,
                                 String status, Long senderId);

    /**
     * 新增订单（自动生成订单编号、设置默认状态为"已发布"）
     */
    boolean addOrder(OrderInfo order);
}