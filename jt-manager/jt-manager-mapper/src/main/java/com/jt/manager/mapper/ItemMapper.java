package com.jt.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.mapper.SysMapper;
import com.jt.manager.pojo.Item;

public interface ItemMapper extends SysMapper<Item> {
	/*分页查询
	 * 
	 */
	List<Item> queryItemPage(@Param("page")int page, @Param("rows")int rows);
	//用于分页插件的使用
	List<Item> findAllItem();
	//商品上架和下架方法
	void updateStatus(@Param("status")int status, @Param("ids")Long[] ids);
	
}
