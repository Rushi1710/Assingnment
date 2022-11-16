package com.boot.application.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUploader {
	
	private ImageUploader() {

	}
	
	public static String uploadImage(String path,MultipartFile  file)
	{
		try {
			String name=file.getOriginalFilename();
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
}
