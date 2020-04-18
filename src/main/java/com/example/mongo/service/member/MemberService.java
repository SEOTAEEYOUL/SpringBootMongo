package com.example.mongo.service.member;

import com.example.mongo.model.member.dto.MemberDTO;

public interface MemberService {
	MemberDTO loginCheck(String userid, String passwd);
	void join(MemberDTO dto);
	// dao 를 호출하기 위한 메소드
}
