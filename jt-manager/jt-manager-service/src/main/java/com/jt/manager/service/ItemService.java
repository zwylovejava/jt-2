package com.jt.manager.service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manager.pojo.Item;

public interface ItemService {

	EasyUIResult queryItem(int page, int rows);

	void updateStatus(int status, Long[] ids);

	void deleteItem(Long[] ids);
	//新增商品
	void saveItem(Item item, String desc);
	//修改商品
	void updateItem(Item item, String desc);

}
