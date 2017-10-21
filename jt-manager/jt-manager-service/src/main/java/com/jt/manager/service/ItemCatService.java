package com.jt.manager.service;

import java.util.List;

import com.jt.manager.pojo.ItemCat;

public interface ItemCatService {

	String findItemCatName(Long itemId);

	List<ItemCat> findItemCatList(Long parentId);

}
