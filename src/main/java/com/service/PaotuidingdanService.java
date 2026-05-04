package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaotuidingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaotuidingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuidingdanView;


/**
 * 跑腿订单
 *
 * @author 
 * @email 
 * @date 2023-06-28 20:55:21
 */
public interface PaotuidingdanService extends IService<PaotuidingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuidingdanVO> selectListVO(Wrapper<PaotuidingdanEntity> wrapper);
   	
   	PaotuidingdanVO selectVO(@Param("ew") Wrapper<PaotuidingdanEntity> wrapper);
   	
   	List<PaotuidingdanView> selectListView(Wrapper<PaotuidingdanEntity> wrapper);
   	
   	PaotuidingdanView selectView(@Param("ew") Wrapper<PaotuidingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuidingdanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<PaotuidingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<PaotuidingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<PaotuidingdanEntity> wrapper);



}

