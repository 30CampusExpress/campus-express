package com.example.errand3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.errand3.entity.Certification;

public interface ICertificationService extends IService<Certification> {

    Page<Certification> getCertificationPage(int pageNum, int pageSize,
                                             String realName, String status);
}