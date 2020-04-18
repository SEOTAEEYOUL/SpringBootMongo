package com.example.mongo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongo.model.member.dto.MemberDTO;
import com.example.mongo.service.member.MemberService;

@Controller // 컨트롤러 빈으로 설정
@RequestMapping("member/*") // 고통적으로 URL 지원
public class MemberController {
	
	@Autowired(required=true) // 의존성 주입 (스프링프레임워크에서 지원하는 어노테이션)
	private MemberService memberService;
	
	@RequestMapping("login.do")  // 세부적인 매핑
	public ModelAndView login( ) {
		return (new ModelAndView("member/login")); // login.jsp 로 이동
	}

	@RequestMapping("login_check.do")
    public ModelAndView login_check(String _id, String passwd, HttpSession session) {
        MemberDTO dto     = memberService.loginCheck(_id, passwd);
        String    message = "";
        String    url     = "";
        if (dto == null) { //로그인 실패/DAOImpl에서 넘긴 null
            message = "로그인 정보가 정확하지 않습니다.";
            url     = "member/login";
        }
        else { //로그인 성공
            message = dto.getName()+"님 환영합니다.";
            url     = "home";
            //세션에 등록
            session.setAttribute("userid", _id);
            session.setAttribute("name", dto.getName());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("message", message);
        return (new ModelAndView(url, "map", map));
    }
	
	@RequestMapping("join.do")
	public String join( ) {
		return ("member/join");
		// join.jsp 회원 가입 페이지로 이동
	}
	
	// 회원 가입 페이지에서 회원가입 내용을 다 작성한 뒷 버튼을 누르면 맵핑되는 메소드
	// dto 에 회원정보를 저장하고, Service 에 값을 전달함
	@RequestMapping("member_join.do")
	public String member_join(String _id, String passwd, String name) {
		MemberDTO dto = new MemberDTO( );
		dto.set_id(_id);
		dto.setPasswd(passwd);
		dto.setName(name);
		memberService.join(dto); // mongodb 에 insert 됨
		return ("redirect:/member/login.do"); // 로그인 화면으로 이동
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		// 세션 정보 초기화
		session.invalidate();
		
		// 로그인 페이지로 이동
		return ("redirect:/member/login.do");
	}	
}
