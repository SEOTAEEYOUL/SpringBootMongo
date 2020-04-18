package com.example.mongo.model.guestbook.dao;

import java.util.List;

import com.example.mongo.model.guestbook.dto.GuestbookDTO;

public interface GuestbookDAO {
	
	public List<GuestbookDTO> getArticleList( );
	public void               articleInsert(GuestbookDTO dto);
	public void               articleUpdate(GuestbookDTO dto);
	public void               articleDelete(String _id);
	public GuestbookDTO       gbDetail(String _id);

}