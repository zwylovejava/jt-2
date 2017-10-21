package com.jt.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manager.pojo.ItemCat;
import com.jt.manager.service.ItemCatService;

@Controller
@RequestMapping("item")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	//cat/queryItemName
	@RequestMapping(value="/cat/queryItemName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findItemCatName(Long itemId){				
		return itemCatService.findItemCatName(itemId);
	}
	//http://localhost:8091/item/cat/list
	@RequestMapping("/cat/list")
	@ResponseBody
	public List<ItemCat> findItemCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		
		return itemCatService.findItemCatList(parentId);
	}
	
}
