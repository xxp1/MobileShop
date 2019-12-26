package com.edu.huatec.mobileshop.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.huatec.mobileshop.image.SecurityCode;
import com.edu.huatec.mobileshop.image.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/image")
public class ImageControl {
	
	
	@RequestMapping("/image1")
	public void createImage(HttpServletResponse response,HttpServletRequest request) throws IOException{

		String code = new SecurityCode().getSecurityCode();
		HttpSession session = request.getSession();
		session.setAttribute("yzm", code);

		BufferedImage image = SecurityImage.createImage(code);
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}
	
	
}
