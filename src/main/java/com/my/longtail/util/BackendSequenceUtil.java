package com.my.longtail.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.my.longtail.model.BackendSequence;
import com.my.longtail.repositories.BackendSequenceRepository;


public class BackendSequenceUtil {

	@Autowired
	private BackendSequenceRepository backendSequenceRepository;
	
	@Value("${upload-path}")
	private String filePath;
	
	public String createUniqueBackendId(String prefix) {
		String resultString = "";
		Date currentDate = new Date();	
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("ddMMyyyy");
		int sequence = getSequence(prefix);
		
		resultString = prefix + "_" + standardDateFormat.format(currentDate) + sequence;
		return resultString;
	}
	
	private int getSequence(String code) {
		boolean isSameDay = false;
		int sequence = 0;
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("dd/MM/yyyy");

//		Map<String, Object> backendSequenceResult = jdbcTemplate.queryForMap("SELECT * FROM backend_sequence WHERE backend_sequence_code = ?", new Object[] {code});
		BackendSequence backendSequenceResult = backendSequenceRepository.findBySequenceName(code);
		Date databaseDate = backendSequenceResult.getModifiedDate();
		Date currentDate = new Date();
		
		System.out.println("Yesterday " + standardDateFormat.format(databaseDate));
		System.out.println("Today " + standardDateFormat.format(currentDate));
		
		if (standardDateFormat.format(databaseDate).compareTo(standardDateFormat.format(currentDate)) == 0)
			isSameDay = true;

		if (isSameDay)
			sequence = (int) backendSequenceResult.getBackendSequence();
		else
			sequence = 1;

		backendSequenceResult.setBackendSequence(sequence);
		backendSequenceResult.setModifiedDate(currentDate);
		backendSequenceResult = backendSequenceRepository.save(backendSequenceResult);
		
		if(backendSequenceResult == null)
			throw new NullPointerException("Could not update backend sequence");
		
		return sequence;
	}
	
	public String saveImageFile(String image_prefix, String base64_img, String existing, String foldername) {
		boolean checker = false;
		String uploadPath = filePath;
		String imageName = createUniqueBackendId(image_prefix);
		String[] splitString = base64_img.split(",");
		byte[] imageBytes = Base64.getDecoder().decode(splitString[1]);

		try {
			File checkdir = new File(uploadPath);
			checkdir.mkdirs();

			if (existing != null) {
				File tempfile = new File(uploadPath + existing);
				tempfile.delete();
			}

			do {
				File checkFile = new File(uploadPath + imageName);
				if (checkFile.exists()) {
					checker = true;
					imageName = createUniqueBackendId(image_prefix);
				} else {
					checker = false;
				}
			} while (checker);

			File file = new File(uploadPath, imageName + ".png");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imageBytes);
			fos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return imageName + ".png";
	}
}
