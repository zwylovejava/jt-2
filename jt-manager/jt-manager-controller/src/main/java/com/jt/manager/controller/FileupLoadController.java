package com.jt.manager.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;

@Controller
public class FileupLoadController {
	//http://localhost:8091/pic/upload?dir=image
	/*
	 *  {"error":0,"url":"图片的保存路径","width":图片的宽度,"height":图片的高度}
			参数说明： 0代表是一张图片，如果是0，前台才可以解析并显示。1代表不是图片，
			不显示如果不设置宽度和高度，则默认用图片原来的大小，所以不用设置

	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult fileupLoad(MultipartFile uploadFile){
		
		PicUploadResult pic = new PicUploadResult();
		//获取文件名;
		String filename = uploadFile.getOriginalFilename();
		//判断是不是图片
		String type = filename.substring(filename.lastIndexOf("."));
		if(!type.matches("^\\.*(jpg|png|gif)$")){
			pic.setError(1);
		}
		//判断是否是非法程序
		try {
			BufferedImage bufferImage = ImageIO.read(uploadFile.getInputStream());
			String width = bufferImage.getWidth()+"";
			String height = bufferImage.getHeight()+"";
			String upath = "http://image.jt.com/images/";
			String rpath = "D://jt-upload/images/";
			pic.setHeight(height);
			pic.setWidth(width);
			//产生随机3位数字
			String num = (int)((Math.random()*9+1)*100)+"";
			filename = num+filename;
			String datePath = new SimpleDateFormat("yyyy/MM/dd/HH").format(new Date());
			rpath=rpath+datePath;
			File file = new File(rpath);
			//判断文件是否存在
			if(!file.exists()){
				file.mkdirs();
			}
			uploadFile.transferTo(new File(rpath+"/"+filename));
			upath=upath+datePath+"/"+filename;
			pic.setUrl(upath);
			
		} catch (IOException e) {
			pic.setError(1);
			
			e.printStackTrace();
		}
		return pic;
	}
	
}
