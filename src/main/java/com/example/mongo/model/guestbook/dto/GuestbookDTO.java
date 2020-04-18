package com.example.mongo.model.guestbook.dto;

import java.util.Date;

public class GuestbookDTO {
	
	private String _id;	// 키값
	private String name;
	private String email;
	private String passwd;
	private String content;
	private Date   post_date;
	
	
	public String get_id( ) {
		return (this._id);
	}
	
	public void set_id(String _id) {
		this._id = _id;
	}
	
	public String getName( ) {
		return (this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail( ) {
		return (this.email);
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswd( ) {
		return (this.passwd);
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getContent( ) {
		return (this.content);
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPost_date( ) {
		return (this.post_date);
	}
	
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
	@Override
	public String toString( ) {
		return ("GuestbookDTO [_id=" + _id + 
				", name=" + name + 
				", email=" + email + 
				", passwd=" + passwd +
				", content=" + content +
				", post_date=" + post_date + "]");
	}
}
