package com.example.mongo.model.memo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.mongo.model.guestbook.dto.GuestbookDTO;
import com.example.mongo.model.memo.dto.MemoDTO;

@Repository
public class MemoDAOImpl implements MemoDAO {
	
	@Autowired // Mongodb 에 사용하기 위해 의존성을 주입한다.
	MongoTemplate mongoTemplate;
	String        COLLECTION_NAME = "memo";
	

	@Override
	public List<MemoDTO> getMemoList() {		
		Query query = new Query();
		// query.with(new Sort(Sort.Direction.DESC, "post_date"));
		// query.with(new Sort(new Order(Sort.Direction.DESC, "post_date").ignoreCase());
		return ((List<MemoDTO>)mongoTemplate.find(// memo 테이블에서 정렬시킨 값을 DTO 타입으로 저장해 리스트를 만들어 리턴한다는 의미이다.
				query, MemoDTO.class, COLLECTION_NAME));
	}

	@Override
	public void memoInsert(MemoDTO dto) {
		// post_date 는 jsp 에서 받아오지 않음으로 추가하여 줌
		dto.setPost_date(new Date( ));
		
		// java.util.Date
		// Insert( 추가할 객체, 컬렉션 이름 )
		mongoTemplate.insert(dto, COLLECTION_NAME);
	}

	@Override
	public MemoDTO memoDetail(String _id) {
		// id 에 해당하는 값(레코드) 1개를 찾을 경우에는 findById(_id, 클래스, 테이블이름) 사용
		
		return (mongoTemplate.findById(_id, MemoDTO.class, COLLECTION_NAME));
	}

	@Override
	public void memoUpdate(MemoDTO dto) {
		// update memo set name=?, memo=?
		// where _id=?
		System.out.println("memoUpdate");
		Query query = new Query(new Criteria("_id").is(dto.get_id( )));
		System.out.println(query);
		// System.out.println(dto.toString( ));
		Update update = new Update( );
		update.set("writer", dto.getWriter());
		update.set("memo", dto.getMemo());
		System.out.println(update);
		// upsert : update or insert
		// mongoTemplate.upsert(query, update, MemoDTO.class, COLLECTION_NAME);
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
	}
	
	/* 게시글을 수정하는 메소드
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
	 */

	@Override
	public void memoDelete(String _id) {
		System.out.println("memoDelete");

		Query query = new Query(new Criteria("_id").is(_id));
		System.out.println(query);
		mongoTemplate.remove(query, COLLECTION_NAME);

	}

}