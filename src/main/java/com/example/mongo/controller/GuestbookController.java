package com.example.mongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mongo.model.guestbook.dao.GuestbookDAO;
import com.example.mongo.model.guestbook.dto.GuestbookDTO;

// 컨트롤러 빈 선언
@Controller
public class GuestbookController {
	
	// 스프링객체 의존성 주입 어노테이션 - dao 를 호출하므로 의존성을 주입
	@Autowired
	GuestbookDAO guestbookDao;
	
	// guestbook.do 로 맵핑되어서 다시 guestbook(jsp 페이지)로 다시 이동한다.
	@RequestMapping("/guestbook.do")
	public String guestbook( ) {
		return ("guestbook/guestbook");
	}
	
	// guestbook(jsp) 페이지가 실행이되면 바로 이 메소드로 맵핑되어서 DAO 에 있는 방명록 리스트를 가져온다.
	@RequestMapping("/gbList.do")
	public ModelAndView gbList( ) {
		List<GuestbookDTO> items = guestbookDao.getArticleList( );
		Map<String, Object> map = new HashMap<>( );
		map.put("list",  items); // 방명록 리스트를 list 라는 이름으로 map(해쉬맵)에 저장한다.
		map.put("count",  items.size( )); // 방명록 리스트의 갯수를 count 라는 이름으로 map(해쉬앱)에 저장
		System.out.println(map);
		return (new ModelAndView("guestbook/gb_list", "map", map));
	}
	
	@RequestMapping("/gbWrite.do")
	public String gbWrite( ) {
		return ("guestbook/gb_write");
	}
	
	@RequestMapping("/gbInsert.do")
	public String gbInsert(@ModelAttribute GuestbookDTO dto) {
		// mongodb 에 Document(레코드) 추가
		guestbookDao.articleInsert(dto);
		
		return ("redirect:/guestbook.do");
	}
	
	@RequestMapping("/gbEdit.do")
	public ModelAndView gbEdit(String _id) {
		// _id : mongodb 의 Document(레코드)의 식별자
		GuestbookDTO dto = guestbookDao.gbDetail(_id);
		Map<String, Object> map = new HashMap<>( );
		map.put("dto",  dto);
		return (new ModelAndView("guestbook/gb_edit", "map", map));
	}
	
	@RequestMapping("/gbUpdate.do")
	public String gbUpdate(@RequestParam String _id,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String content,
			@RequestParam String passwd) {
		// System.out.println(dto);
		// Document(레코드) 수정
		GuestbookDTO dto = new GuestbookDTO( );
		dto.set_id(_id);
		dto.setName(name);
		dto.setEmail(email);
		dto.setContent(content);
		dto.setPasswd(passwd);
		
		guestbookDao.articleUpdate(dto);
		
		// 목록 페이지로 이동		
		return ("redirect:/guestbook.do");		
	}
	
	@RequestMapping("/gbDelete.do")
	public String gbDelete(String _id) {
		// Document(레코드) 삭제
		guestbookDao.articleDelete(_id);
		
		return ("redirect:/guestbook.do");
	}

}
