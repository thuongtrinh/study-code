package com.txt.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.txt.dto.Product;

public class FileUploadUtility {

	public static void uploadFile(MultipartFile multipartFile, HttpServletRequest request, Product product) {
		String nameFile = multipartFile.getOriginalFilename();
		System.out.println("NameFile is: " + nameFile);
		if (!nameFile.equals("")) {
			// Get path of project directory upload
			String ABS_PATH = "D:\\CODE\\CodeWeb\\EShopper\\src\\main\\webapp\\assets\\images\\home\\";
			// get the real path (the directory to store file)
			String REAL_PATH = request.getServletContext().getRealPath("/assets/images/home/"); // here will upload to server

			System.out.println(REAL_PATH);
			System.out.println(ABS_PATH);

			File fileDir_real = new File(REAL_PATH);
			if (!fileDir_real.exists()) {
				fileDir_real.mkdir();
			}

			File fileDir_abs = new File(ABS_PATH);
			if (!fileDir_abs.exists()) {
				fileDir_abs.mkdir();
			}

			try {
				// server upload
				multipartFile.transferTo(new File(fileDir_abs + File.separator + nameFile));
				// project directory upload
				multipartFile.transferTo(new File(fileDir_real + File.separator + nameFile));
				product.setImageURL(nameFile);
				System.out.println("Upload file successfully!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println("Upload file failed!");
			}
		}
	}

}
