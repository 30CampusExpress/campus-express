package com.example.errand3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.Notice;
import com.example.errand3.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @GetMapping("/list")
    public Result<Page<Notice>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(required = false) String title) {
        return Result.success(noticeService.getNoticePage(pageNum, pageSize, title));
    }

    @PostMapping
    public Result<?> add(@RequestBody Notice notice) {
        noticeService.save(notice);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Notice notice) {
        noticeService.updateById(notice);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        noticeService.removeBatchByIds(ids);
        return Result.success();
    }
}