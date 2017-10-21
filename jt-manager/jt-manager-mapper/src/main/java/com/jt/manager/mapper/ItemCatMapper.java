package com.jt.manager.mapper;

import com.jt.common.mapper.SysMapper;
import com.jt.manager.pojo.ItemCat;

public interface ItemCatMapper extends SysMapper<ItemCat>{
	//根据ID查询商品分类名称
	String findItemCatName(Long itemId);

}
