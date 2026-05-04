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


import com.dao.JianzhirenyuanDao;
import com.entity.JianzhirenyuanEntity;
import com.service.JianzhirenyuanService;
import com.entity.vo.JianzhirenyuanVO;
import com.entity.view.JianzhirenyuanView;

@Service("jianzhirenyuanService")
public class JianzhirenyuanServiceImpl extends ServiceImpl<JianzhirenyuanDao, JianzhirenyuanEntity> implements JianzhirenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianzhirenyuanEntity> page = this.selectPage(
                new Query<JianzhirenyuanEntity>(params).getPage(),
                new EntityWrapper<JianzhirenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianzhirenyuanEntity> wrapper) {
		  Page<JianzhirenyuanView> page =new Query<JianzhirenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JianzhirenyuanVO> selectListVO(Wrapper<JianzhirenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianzhirenyuanVO selectVO(Wrapper<JianzhirenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianzhirenyuanView> selectListView(Wrapper<JianzhirenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianzhirenyuanView selectView(Wrapper<JianzhirenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JianzhirenyuanEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JianzhirenyuanEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JianzhirenyuanEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
