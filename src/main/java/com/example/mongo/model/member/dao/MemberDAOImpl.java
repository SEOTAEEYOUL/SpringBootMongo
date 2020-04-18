package com.example.mongo.model.member.dao;

import java.util.List;

// import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.example.mongo.model.member.dto.MemberDTO;

@Repository
// DAO 에서 사용하느 어노테이션, Component 도 사용 가능하다.
// sql 를 쓸 수 없으므로 함수를 사용해서 명령을 표현
public class MemberDAOImpl implements MemberDAO {
	
	
	// mongodb 에 접속하여 명령어를 실행하는 객체
	// Autowired 대신에 inject 를 써도 된다.
	// Inject 를 사용하려면 pom.xml 에 라이브러리를 추가해 주어야 한다.
	// Inject 어노테이션을 쓰고 우크릭 후 fix Project Setup 을 누르고 jar 파일에 대고
	// ok 를 누르면 Inject 를 사용할 수 있다.
	// @Inject
	@Autowired
	private MongoTemplate mongoTemplate;
	// bean 에 MongoTemplate 를 리턴하는 메소드가 있었는데 이 메소드가 실행되어야
	// MongoDB 를 사용할 수 있기 때문에 의존관계를 주입시키는 것이다.
	// 템플릿을 사용하기 위한 의존성 주입
	
	// mongodb 의 켈렉션(테이블에 해당)
	// 그리고 레코드 대신 도큐먼트(document) 라고 부르고 사용한다.
	String COLLECTION_NAME = "member"; // collection(table) name
	

	// 로그인 체크
	@Override
	public MemberDTO loginCheck(String userid, String passwd) {
		// _id : Document(레코드에 해당)의 식별자
		Query query = new Query(new Criteria("_id").is(userid) // 키값 (_id) 가 userid 와 같고,
				.and("passwd").is(passwd)); // passwd 와 passwd(입력한 값)이 같은지 확인
		
		// mongoTemplate.find(쿼리, 리턴자료형, 컬렉션이름)
		// 리스트가 리턴되므로 get(0) 첫번째 Document 만 리턴
		List<MemberDTO> list=mongoTemplate.find(query, MemberDTO.class, COLLECTION_NAME);
		// COLLECTION_NAME 는 테이블 이름이고, 위의 결과가 참이되면
		// DTO 에다 아이디와 비밀번호를 저장한다.
		
				
		// 만일 list 가 0보다 크면 1개만 출력되고 아니면 null 이 출력된다.
		if (list.size( ) > 0) {
			return (list.get(0));
		}
		else {
			return (null);
		}
	}

	// 회원가입 처리
	// insert 라고 생각하면 된다.
	@Override
	public void join(MemberDTO dto) {
		// Document 가 생성됨(insert)
		// dto 안에 들어 있는 값을 COLLECTION_NAME 컬렉션(테이블)에 저장한다는 의미
		mongoTemplate.insert(dto, COLLECTION_NAME);
	}

}
