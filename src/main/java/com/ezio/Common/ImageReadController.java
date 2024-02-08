package com.ezio.Common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageReadController {
	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/";

	@RequestMapping("/uploads/{productImage}")
	public String geBooktProductImage(@PathVariable("productImage") String productImage, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(uploadProductDirectory + productImage));
			response.setContentLength(b.length);
			response.setContentType("image/jpg");
// response.setContentType("application/mp3");
// response.setContentType("application/pdf");

			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * @RequestMapping("/uploads/song/{song}") public String
	 * getBannerImage(@PathVariable("song") String song, HttpServletResponse
	 * response) { try { byte b[] = Files.readAllBytes(Paths.get(uploadSongDirectory
	 * + song)); response.setContentLength(b.length);
	 * response.setContentType("application/mp3"); ServletOutputStream os =
	 * response.getOutputStream(); os.write(b); os.flush(); } catch (IOException e)
	 * { e.printStackTrace(); } return null;
	 *
	 * }
	 */

}
