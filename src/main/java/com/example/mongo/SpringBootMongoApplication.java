package com.example.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트 시작 어노테이션
public class SpringBootMongoApplication {

	// 메인 메소드 이 java 파일에서 프로젝트가 실행이 된다.
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}

}
