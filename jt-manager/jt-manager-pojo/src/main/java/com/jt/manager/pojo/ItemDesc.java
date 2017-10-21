package com.jt.manager.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;

@Table(name="tb_item_desc")
public class ItemDesc extends BasePojo {
	/**
	 * create table tb_item_desc
		(
		   item_id              bigint(10) not null comment '商品ID',
		   item_desc            text,
		   created              datetime,
		   updated              datetime,
		   primary key (item_id)
		);
	 */	
	@Id
	private Long itemId; //商品ID
	private String itemDesc;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	
	
}
