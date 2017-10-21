package com.jt.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manager.mapper.ItemDescMapper;
import com.jt.manager.pojo.ItemDesc;
@Service
public class ItemDescServiceImpl implements ItemDescService {
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Override
	public ItemDesc findDesc(Long itemId) {
		return itemDescMapper.selectByPrimaryKey(itemId);
	}

}
