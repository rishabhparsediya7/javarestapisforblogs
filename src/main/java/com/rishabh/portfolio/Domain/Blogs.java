package com.rishabh.portfolio.Domain;

import java.time.LocalDateTime;

import com.google.cloud.Date;



public class Blogs {
	
	
	private String id;
	private String title;
	private String content;
	private String date;
	
	public Blogs(String id, String title, String content, String date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public Blogs() {
		
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Blogs [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
