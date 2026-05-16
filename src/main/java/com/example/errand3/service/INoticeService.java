package com.example.errand3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.errand3.entity.Notice;

public interface INoticeService extends IService<Notice> {

    Page<Notice> getNoticePage(int pageNum, int pageSize, String title);
}