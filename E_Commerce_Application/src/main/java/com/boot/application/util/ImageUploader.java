package com.boot.application.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.boot.application.service.ProductService;

@Component
public class ImageUploader {
	
	@Autowired
	ProductService productService;
	int productId;
	
	private ImageUploader() {

	}
	
	public String uploadImage(String path,MultipartFile  file) 
	{
		try {
			String name=file.getOriginalFilename();
			
			if(name.isEmpty()) {
				System.out.println("name is empty adding new name :" +this.productService.getProductById(productId).getImage());
				return this.productService.getProductById(productId).getImage();
				
			}
			String randomId=UUID.randomUUID().toString();
			String fileName=randomId.concat(name.substring(name.lastIndexOf(".")));
			
			System.out.println(fileName);			
			String fullpath=path+File.separator+fileName;
			File f=new File(path);

			if(!f.exists())
				f.mkdir();
			
			Files.copy(file.getInputStream(),Paths.get(fullpath));
			return fileName;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public void setId(int id) {
		this.productId=id;
	}
}
