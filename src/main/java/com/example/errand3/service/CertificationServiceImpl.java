package com.example.errand3.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.errand3.entity.Certification;
import com.example.errand3.mapper.CertificationMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CertificationServiceImpl extends ServiceImpl<CertificationMapper, Certification>
        implements ICertificationService {

    @Override
    public Page<Certification> getCertificationPage(int pageNum, int pageSize,
                                                    String realName, String status) {
        LambdaQueryWrapper<Certification> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(realName), Certification::getRealName, realName);
        wrapper.eq(StringUtils.hasText(status), Certification::getStatus, status);
        wrapper.orderByDesc(Certification::getId);
        return this.page(new Page<>(pageNum, pageSize), wrapper);
    }
}