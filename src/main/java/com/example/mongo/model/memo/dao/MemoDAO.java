package com.example.mongo.model.memo.dao;

import java.util.List;

import com.example.mongo.model.memo.dto.MemoDTO;

public interface MemoDAO {
	
	List<MemoDTO> getMemoList( );    // 목록 보기
	void memoInsert(MemoDTO dto);    // 글쓰기
	MemoDTO memoDetail(String _id);  // 상세화면
	void memoUpdate(MemoDTO dto);    // 글수정
	void memoDelete(String _id);     // 글 삭제    
}