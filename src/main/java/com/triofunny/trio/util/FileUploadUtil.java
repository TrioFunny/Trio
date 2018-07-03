package com.triofunny.trio.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static String getfilePath(MultipartFile headFile, HttpServletRequest request) {
		String path = null;
		try {
			String realpath = "D:\\develope\\picture";
			String filename = UUID.randomUUID().toString() + "."
					+ FilenameUtils.getExtension(headFile.getOriginalFilename());
			File f = new File(realpath + "/" + filename);
			FileUtils.copyInputStreamToFile(headFile.getInputStream(), f);
			path = "static/image/" + filename;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
