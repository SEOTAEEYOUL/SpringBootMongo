package com.example.mongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 컨들로러 빈으로 등록
public class HomeController {
	// http://localhost 까지만 나온다는 뜻, 시작 페이지
	@RequestMapping("/")
	public String home( ) {
		// /WEB-INF/view/home.jsp
		return ("home"); // home.jsp 로 포워딩
		// home.jsp 페이지가 출력된다
	}

}