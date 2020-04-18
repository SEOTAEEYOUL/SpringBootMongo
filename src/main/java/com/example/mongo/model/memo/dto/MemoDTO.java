package com.example.mongo.model.memo.dto;

import java.util.Date;

import com.example.mongo.model.guestbook.dto.GuestbookDTO;

import java.text.SimpleDateFormat;

public class MemoDTO {
	
	private String _id;
	private String writer;
	private String memo;
	private Date   post_date;
	
	public MemoDTO(String _id, String writer, String memo, Date post_date) {
		this._id = _id;
		this.writer = writer;
		this.memo = memo;
		this.post_date = post_date;
	}
	
	
	// getter/setter, toString( )
	public String get_id( ) {
		return (this._id);
	}

	public void set_id(String _id) {
		System.out.println("_id[" + _id + "]");
		this._id = _id;
	}

	
	public String getWriter( ) {
		return (this.writer);
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getMemo( ) {
		return (this.memo);
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public Date getPost_date( ) {
		return (this.post_date);
	}
	
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
	@Override
	public String toString( ) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		String dateString = post_date == null ? "" : format.format(this.post_date);

		return ("_id : " + this._id + ", writer :" + this.writer + ", memo : " + ", post_date :" + dateString);
	}
}
