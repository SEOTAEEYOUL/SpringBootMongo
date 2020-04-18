package com.example.mongo.model.member.dao;

import com.example.mongo.model.member.dto.MemberDTO;

public interface MemberDAO {
	MemberDTO loginCheck(String userid, String passwd); // 로그인 체크 메소드
	void join(MemberDTO dto);
}
