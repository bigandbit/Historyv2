package com.example.demo.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class DownloadPdf {
	public static void download(HttpServletResponse response) throws IOException {
		File file = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		file = new File(classLoader.getResource("result.pdf").getFile());
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		response.setContentLength((int) file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
		if (response.getOutputStream() != null) {
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}

	}
}
