package com.my.longtail.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

import com.my.longtail.logger.Logger;
import com.my.longtail.property.Property;

public class UserUtil {

	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
	public static String randomString(int length) {
		String SALTCHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random random = new Random();
		
		while(salt.length() < length) {
			int index = (int) (random.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		
		return salt.toString();
	}
	
	public static String saveImageFile(String base64_img, String existing, String uploadPath) {
		boolean checker = false;
		String imageName = randomString(8);
		String[] splitString = base64_img.split(",");
		byte[] imageBytes = Base64.getDecoder().decode(splitString[1]);
		
		try {
			File checkdir = new File(uploadPath);
			checkdir.mkdirs();
			
			if(existing != null) {
				File tempfile = new File(uploadPath + existing);
				tempfile.delete();
			}
			
			do {
				File checkfile = new File(uploadPath + imageName);
				if(checkfile.exists()) {
					checker = true;
					imageName = randomString(8);
				}else
					checker = false;
			} while(checker);
			
			File file = new File(uploadPath, imageName + ".png");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imageBytes);
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
		}
		
		return imageName + ".png";
	}
}
