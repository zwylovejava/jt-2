package com.jt.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	//使用RestFull结构
	@RequestMapping("page/{moudleName}")
	public String homeAction(@PathVariable String moudleName){
		return moudleName;
	}
}
