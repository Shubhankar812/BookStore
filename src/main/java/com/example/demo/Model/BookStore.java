package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class BookStore {
	private int id;
	private String name;
	private String authorName;
	private String publisherName;
	private boolean isDeleted;
	
	public BookStore(int id,String Name,String Author,String Publisher,boolean check) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=Name;
		this.authorName=Author;
		this.publisherName=Publisher;
		this.isDeleted=check;
	}
	 public BookStore() {
	        // Default initialization if necessary
	    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
