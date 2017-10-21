package com.jt.manager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.common.vo.EasyUIResult;
import com.jt.manager.mapper.ItemDescMapper;
import com.jt.manager.mapper.ItemMapper;
import com.jt.manager.pojo.Item;
import com.jt.manager.pojo.ItemDesc;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;
	/**
	 * {"total":2000,"rows":[{},{},{}]}
	 */
	@Override
	public EasyUIResult queryItem(int page, int rows) {
		/*		//先查询出总的记录数
		int total = itemMapper.selectCount(null);
	   //查出当前分页的数据
		//1计算limit p1,p2
		page=(page-1)*rows;
		List<Item> listItem = itemMapper.queryItemPage(page,rows);*/		
		//使用分页插件进行分页操作
		PageHelper.startPage(page, rows);
		//分页插件会自动拼接Sql进行分页查询
		List<Item> listItem = itemMapper.findAllItem();
		PageInfo<Item> pageInfo = new PageInfo<Item>(listItem);						
		return new EasyUIResult(pageInfo.getTotal(),listItem);
	}
	@Override
	public void updateStatus(int status, Long[] ids) {
		itemMapper.updateStatus(status,ids);
		
	}
	@Override
	public void deleteItem(Long[] ids) {

		itemDescMapper.deleteByIDS(ids);
		itemMapper.deleteByIDS(ids);
	}
	@Override
	public void saveItem(Item item, String desc) {
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());		
		itemMapper.insertSelective(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getCreated());
		itemDescMapper.insert(itemDesc);		
	}
	@Override
	public void updateItem(Item item, String desc) {
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setUpdated(item.getUpdated());
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(item.getId());
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
	}
	
}
