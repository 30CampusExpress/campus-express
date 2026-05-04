package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DingdanqianshouDao;
import com.entity.DingdanqianshouEntity;
import com.service.DingdanqianshouService;
import com.entity.vo.DingdanqianshouVO;
import com.entity.view.DingdanqianshouView;

@Service("dingdanqianshouService")
public class DingdanqianshouServiceImpl extends ServiceImpl<DingdanqianshouDao, DingdanqianshouEntity> implements DingdanqianshouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanqianshouEntity> page = this.selectPage(
                new Query<DingdanqianshouEntity>(params).getPage(),
                new EntityWrapper<DingdanqianshouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanqianshouEntity> wrapper) {
		  Page<DingdanqianshouView> page =new Query<DingdanqianshouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DingdanqianshouVO> selectListVO(Wrapper<DingdanqianshouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanqianshouVO selectVO(Wrapper<DingdanqianshouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanqianshouView> selectListView(Wrapper<DingdanqianshouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanqianshouView selectView(Wrapper<DingdanqianshouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
