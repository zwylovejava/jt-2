package com.jt.manager.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manager.pojo.Item;
import com.jt.manager.pojo.ItemDesc;
import com.jt.manager.service.ItemDescService;
import com.jt.manager.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemDescService itemDescService;
	private Logger logger = Logger.getLogger(ItemController.class);
	//http://localhost:8091/item/query?page=1&rows=20
	//{"total":2000,"rows":[{},{},{}]}
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult queryItem(int page,int rows){						
		return itemService.queryItem(page,rows);		
	}
	//http://localhost:8091/item/instock
	@RequestMapping("/instock")
	@ResponseBody
	public SysResult instock(Long[] ids){
		int status=2;
		try {
			itemService.updateStatus(status,ids);
			logger.info("商品下架成功");
			return SysResult.build(200, "商品下架成功");
		} catch (Exception e) {
			logger.info(e.getMessage());
			return SysResult.build(201, "商品下架失败");
		}
		
	}
	@RequestMapping("/reshelf")
	@ResponseBody
	public SysResult reshelf(Long[] ids){
		int status=1;
		try {
			itemService.updateStatus(status,ids);
			logger.info("商品上架成功");
			return SysResult.build(200, "商品上架成功");
		} catch (Exception e) {
			logger.info(e.getMessage());
			return SysResult.build(201, "商品上架失败");
		}
		
	}	
	//item/query/item/desc/'+data.id
	@RequestMapping("/query/item/desc/{ItemId}")
	@ResponseBody
	public SysResult findDesc(@PathVariable Long ItemId){
		try {
			ItemDesc itemDesc= itemDescService.findDesc(ItemId);
			logger.info("商品描述查询成功");
			return SysResult.build(200, "商品描述查询成功", itemDesc);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			return SysResult.build(201, "商品描述查询失败", null);
		}		
	}
	//http://localhost:8091/item/delete
	@RequestMapping("/delete")
	@ResponseBody
	public SysResult deleteItem(Long[] ids){
		try {
			itemService.deleteItem(ids);
			logger.info("商品删除成功");
			return SysResult.build(200, "商品删除成功");
		} catch (Exception e) {
			logger.info(e.getMessage());
			return SysResult.build(200, "商品删除失败");
		}		
	}
	//http://localhost:8091/item/save
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item,String desc){
		try {
			itemService.saveItem(item,desc);
			logger.info("商品新增成功");
			return SysResult.build(200, "商品新增成功");
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return SysResult.build(201, "商品新增失败");
		}
	}
	//http://localhost:8091/item/update
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item,String desc){
		try {
			itemService.updateItem(item,desc);
			logger.info("商品修改成功");
			return SysResult.build(200, "商品修改成功");
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			return SysResult.build(201, "商品修改失败");
		}
	}
	
	
}
