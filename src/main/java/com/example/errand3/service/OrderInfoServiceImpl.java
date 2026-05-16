package com.example.errand3.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.errand3.entity.OrderInfo;
import com.example.errand3.mapper.OrderInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
        implements IOrderInfoService {

    @Override
    public Page<OrderInfo> getOrderPage(int pageNum, int pageSize,
                                        String orderNo, String goodsName,
                                        String status, Long senderId) {
        // 创建查询条件包装器
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();

        // 按订单编号模糊搜索
        wrapper.like(StringUtils.hasText(orderNo), OrderInfo::getOrderNo, orderNo);
        // 按物品名称模糊搜索
        wrapper.like(StringUtils.hasText(goodsName), OrderInfo::getGoodsName, goodsName);
        // 按订单状态精确匹配
        wrapper.eq(StringUtils.hasText(status), OrderInfo::getStatus, status);
        // 按发起人ID精确匹配
        wrapper.eq(senderId != null, OrderInfo::getSenderId, senderId);
        // 按创建时间倒序排列（最新的排最前）
        wrapper.orderByDesc(OrderInfo::getCreateTime);

        // 创建分页对象，pageNum当前页，pageSize每页条数
        Page<OrderInfo> page = new Page<>(pageNum, pageSize);
        return this.page(page, wrapper);
    }

    @Override
    public boolean addOrder(OrderInfo order) {
        // 如果前端没传状态，默认设为"已发布"
        if (!StringUtils.hasText(order.getStatus())) {
            order.setStatus("已发布");
        }
        // 自动生成订单编号：当前时间 + 3位随机数
        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String random = String.format("%03d", (int)(Math.random() * 900) + 100);
        order.setOrderNo(dateStr + random);
        // 保存到数据库
        return this.save(order);
    }
}