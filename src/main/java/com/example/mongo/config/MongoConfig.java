package com.example.mongo.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

// application.properties 에서 설정한 MongoDB 에 정보를 읽어서 Bean 을 생성하는 페이지
// 스프링부트에서 servlet-context, root-context 가 없기 때문에

//Configuration 어노테이션은 root-context 안에 들어갈 코드를 어노테이션으로 만든것이라고 생각하면 된다.
@Configuration 
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Value("${spring.data.mongodb.username}") // application.properties 에서 정의한 MongoDB 계정 아이디
	private String userName;
	
	@Value("${spring.data.mongodb.password}") // application.properties 에서 정의한 MongoDB 예 계정 비밀 번호
	private String password;
	
	@Value("${spring.data.mongodb.database}") // application.properties 에서 정의한 MongoDB 에 있는 데이터베이스
	private String database;
	
	// @Override
	protected String getDatabaseName( ) {
		return (database);
	}
	
	// 레거시 프로젝트에서 xml 파일 안에 xml 파일 안에 <bean> 테그 안에 있던 코드를 적어 놓은것.
	// mongotemplate 를 만들어서 리턴해 준다.
	public @Bean MongoTemplate mongoTemplate( ) throws Exception {
		return (new MongoTemplate((MongoClient) mongoClient( ), database));
	}
	
	@Override // extends AbstractMongoConfiguration
	public MongoClient mongoClient( ) {
		MongoCredential credential = // 인증 정보, 비밀번호는 문자열로
				MongoCredential.createCredential(userName, database, password.toCharArray( ));
		// 서버 주소에 호수트, port num, credential
		return (new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential)));
	}	

}
