package com.example.mongo.service.memo;

import java.util.List;

import com.example.mongo.model.memo.dto.MemoDTO;

public interface MemoService {
	
	List<MemoDTO> getMemoList( );          // 목록 저장         
	void          memoInsert(MemoDTO dto); // 메모 저장
	MemoDTO       memoDetail(String _id);  // 메모 상세 내용 보기
	void          memoUpdate(MemoDTO dto); // 메모 수정
	void          memoDelete(String _id);  // 메모 삭제

}