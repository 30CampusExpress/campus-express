package com.example.errand3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.errand3.common.Result;
import com.example.errand3.entity.Certification;
import com.example.errand3.service.ICertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certification")
public class CertificationController {

    @Autowired
    private ICertificationService certificationService;

    // 分页查询
    @GetMapping("/list")
    public Result<Page<Certification>> list(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            @RequestParam(required = false) String realName,
                                            @RequestParam(required = false) String status) {
        return Result.success(certificationService.getCertificationPage(pageNum, pageSize, realName, status));
    }

    // 提交认证申请（新增）
    @PostMapping
    public Result<?> add(@RequestBody Certification certification) {
        certification.setStatus("待审核"); // 默认状态
        certificationService.save(certification);
        return Result.success();
    }

    // 审核操作（修改状态和理由）
    @PutMapping
    public Result<?> update(@RequestBody Certification certification) {
        certificationService.updateById(certification);
        return Result.success();
    }

    // 删除认证记录
    @DeleteMapping("/{ids}")
    public Result<?> delete(@PathVariable List<Long> ids) {
        certificationService.removeBatchByIds(ids);
        return Result.success();
    }
}