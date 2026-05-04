package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianzhirenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianzhirenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianzhirenyuanView;


/**
 * 兼职人员
 *
 * @author 
 * @email 
 * @date 2023-06-28 20:55:20
 */
public interface JianzhirenyuanService extends IService<JianzhirenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianzhirenyuanVO> selectListVO(Wrapper<JianzhirenyuanEntity> wrapper);
   	
   	JianzhirenyuanVO selectVO(@Param("ew") Wrapper<JianzhirenyuanEntity> wrapper);
   	
   	List<JianzhirenyuanView> selectListView(Wrapper<JianzhirenyuanEntity> wrapper);
   	
   	JianzhirenyuanView selectView(@Param("ew") Wrapper<JianzhirenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianzhirenyuanEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JianzhirenyuanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JianzhirenyuanEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JianzhirenyuanEntity> wrapper);



}

