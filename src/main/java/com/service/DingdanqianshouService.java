package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanqianshouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanqianshouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanqianshouView;


/**
 * 订单签收
 *
 * @author 
 * @email 
 * @date 2023-06-28 20:55:21
 */
public interface DingdanqianshouService extends IService<DingdanqianshouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanqianshouVO> selectListVO(Wrapper<DingdanqianshouEntity> wrapper);
   	
   	DingdanqianshouVO selectVO(@Param("ew") Wrapper<DingdanqianshouEntity> wrapper);
   	
   	List<DingdanqianshouView> selectListView(Wrapper<DingdanqianshouEntity> wrapper);
   	
   	DingdanqianshouView selectView(@Param("ew") Wrapper<DingdanqianshouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanqianshouEntity> wrapper);
   	

}

