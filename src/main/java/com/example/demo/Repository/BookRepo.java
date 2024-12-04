package com.example.demo.Repository;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BookStore> getAllBooks() {
		String query="select * from BookStore";
		RowMapper<BookStore> mapper = new RowMapper<BookStore>() {
			@Override
			public BookStore mapRow(ResultSet rs,int rowNum) throws SQLException {
				 return new BookStore(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("authorName"),
	                        rs.getString("publisherName"), false
	                );
	            }
	        };
	        List<BookStore> results = jdbcTemplate.query(query, mapper);
	        return results;
			
		}
	 public void insert(BookStore book){
	        String sql = "insert into bookstore(id,name,authorName,publisherName,isDeleted) values(?,?,?,?,false)";
	        jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthorName(), book.getPublisherName());
	    }
	 public void delete(int id) {
		 String query = "DELETE FROM BookStore WHERE id = ?";
		 jdbcTemplate.update(query,id);
	 }
	 
	 public void update(int i,BookStore book) {
		 String query= "UPDATE BookStore SET name=?, authorName=?, publisherName=? WHERE id=?";
		 jdbcTemplate.update(query,book.getName(),book.getAuthorName(),book.getPublisherName(),book.getId());
	 }
	 
		
	}
	

