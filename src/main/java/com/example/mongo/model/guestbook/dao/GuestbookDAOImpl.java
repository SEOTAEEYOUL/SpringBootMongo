package com.example.mongo.model.guestbook.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongo.model.guestbook.dao.GuestbookDAO;
import com.example.mongo.model.guestbook.dto.GuestbookDTO;

@Repository
public class GuestbookDAOImpl implements GuestbookDAO {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	String        COLLECTION_NAME = "guestbook";

	// 방명록 리스트를 보여주는 메소드
	@Override
	public List<GuestbookDTO> getArticleList() {
		// db 에 명령 내릴 것들을 저장하는 객체인 query 객체 생성
		Query query = new Query( );
		// query.with(new Sort(Sort.Direction.DESC, "post_date"));		
		List<GuestbookDTO> list =
				(List<GuestbookDTO>)mongoTemplate.find(query, GuestbookDTO.class, COLLECTION_NAME);
		
		for (GuestbookDTO dto : list) {
			// list 에 있는 값드를 dto 에 넣고, 줄간격을 줌
			String content = dto.getContent();
			content = content.replace("\r\n", "<br>");
			dto.setContent(content);
		}
				
		
		return (list);
	}

	// 방명록 글쓰기 메쏘드
	@Override
	public void articleInsert(GuestbookDTO dto) {
		dto.setPost_date(new Date( ));
		mongoTemplate.insert(dto, COLLECTION_NAME);
	
	}

	// 게시글을 수정하는 메소드
	@Override
	public void articleUpdate(GuestbookDTO dto) {
		// update guestbook set name=?, email=?, content=?
		// where _id=?
		// new Criteria("필드명").is(값)
		System.out.println(dto);
		Query query = new Query(new Criteria("_id").is(dto.get_id( )));
		// 수정할 내용들을 매핑
		Update update = new Update( );
		update.set("name",  dto.getName());
		update.set("email",  dto.getEmail());
		update.set("content",  dto.getContent());
		
		// 1 개의 레코드만 수정(1 개의 게시물만 수정한다는 뜻이다. _id 값(키값) 을 한개만 받아 왔기 때문에)
		// query = 날짜 내림차순으로 정렬시키는 쿼리
		// upate = 이름, 이메일, 글내용
		// COLLECTION_NAME = 테이릅 이름
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);	
	}

	// 게시글을 삭제하는 메소드
	@Override
	public void articleDelete(String _id) {
		// 저장된 _id 값이 내가 입력한 _id 값과 같은지 확인하고, 그 값을 query 객체에 저장
		Query query = new Query(new Criteria("_id").is(_id));
		
		// _id 값(키값)과 COLLECTION_NAME(테이블명) 으로 자료를 삭제한다.
		mongoTemplate.remove(query, COLLECTION_NAME);
	}

	// 게시물 1개의 상세 정보를 보여주는 메소드
	@Override
	public GuestbookDTO gbDetail(String _id) {
		// findById( ) 1개의 Document 리턴
		// find( ) Document 리스트 리턴
		// findById(_id, 자료형 클래스, 컬렉션 이름)
		// _id 갑스로 COLLECTION_NAME(테이블) 에 저장된 값들을 DTO 타입으로 저장해서 리턴한다.
		return (mongoTemplate.findById(_id,  GuestbookDTO.class, COLLECTION_NAME));
	}

}