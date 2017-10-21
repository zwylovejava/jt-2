package com.jt.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manager.mapper.ItemCatMapper;
import com.jt.manager.pojo.ItemCat;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private ItemCatMapper itemCatMapper;
	@Override
	public String findItemCatName(Long itemId) {				
		return itemCatMapper.findItemCatName(itemId);
	}
	@Override
	public List<ItemCat> findItemCatList(Long parentId) {
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);
		return itemCatMapper.select(itemCat);
	}

}
