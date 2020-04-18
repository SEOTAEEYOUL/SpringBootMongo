package com.example.mongo.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mongo.model.member.dao.MemberDAO;
import com.example.mongo.model.member.dto.MemberDTO;

@Component // 빈에 등록
public class MemberServiceImpl implements MemberService {
	
	@Autowired // 의존성 주입
	private MemberDAO memberDao;

	@Override
	public MemberDTO loginCheck(String userid, String passwd) {
		// TODO Auto-generated method stub
		return (memberDao.loginCheck(userid, passwd));
	}

	@Override
	public void join(MemberDTO dto) {
		// TODO Auto-generated method stub
		memberDao.join(dto);

	}

}
