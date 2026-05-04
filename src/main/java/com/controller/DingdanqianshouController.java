package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DingdanqianshouEntity;
import com.entity.view.DingdanqianshouView;

import com.service.DingdanqianshouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单签收
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-28 20:55:21
 */
@RestController
@RequestMapping("/dingdanqianshou")
public class DingdanqianshouController {
    @Autowired
    private DingdanqianshouService dingdanqianshouService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanqianshouEntity dingdanqianshou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			dingdanqianshou.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jianzhirenyuan")) {
			dingdanqianshou.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingdanqianshouEntity> ew = new EntityWrapper<DingdanqianshouEntity>();

		PageUtils page = dingdanqianshouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanqianshou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanqianshouEntity dingdanqianshou, 
		HttpServletRequest request){
        EntityWrapper<DingdanqianshouEntity> ew = new EntityWrapper<DingdanqianshouEntity>();

		PageUtils page = dingdanqianshouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanqianshou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanqianshouEntity dingdanqianshou){
       	EntityWrapper<DingdanqianshouEntity> ew = new EntityWrapper<DingdanqianshouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanqianshou, "dingdanqianshou")); 
        return R.ok().put("data", dingdanqianshouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanqianshouEntity dingdanqianshou){
        EntityWrapper< DingdanqianshouEntity> ew = new EntityWrapper< DingdanqianshouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanqianshou, "dingdanqianshou")); 
		DingdanqianshouView dingdanqianshouView =  dingdanqianshouService.selectView(ew);
		return R.ok("查询订单签收成功").put("data", dingdanqianshouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanqianshouEntity dingdanqianshou = dingdanqianshouService.selectById(id);
        return R.ok().put("data", dingdanqianshou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanqianshouEntity dingdanqianshou = dingdanqianshouService.selectById(id);
        return R.ok().put("data", dingdanqianshou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanqianshouEntity dingdanqianshou, HttpServletRequest request){
    	dingdanqianshou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanqianshou);
        dingdanqianshouService.insert(dingdanqianshou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanqianshouEntity dingdanqianshou, HttpServletRequest request){
    	dingdanqianshou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingdanqianshou);
        dingdanqianshouService.insert(dingdanqianshou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanqianshouEntity dingdanqianshou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanqianshou);
        dingdanqianshouService.updateById(dingdanqianshou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanqianshouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
