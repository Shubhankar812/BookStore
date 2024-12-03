package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.BookStore;
import com.example.demo.Service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/")
	public List<BookStore> getBooks() {
		return service.getBooks();
	}
	
	@GetMapping("/{bookId}")
	public BookStore getBookById(@PathVariable int bookId){
		return service.getRecordById(bookId);
	}
	
	@PostMapping("/book")
	public void addBookToDB(@RequestBody BookStore book) {
		service.addBook(book);
	}
	
	@PutMapping("/update-record")
	public void updateRecord(@RequestBody BookStore book) {
		service.updateRecord(book);
	}
	
	@DeleteMapping("/delete-record/{bookId}")
	public void deleteRecord(@PathVariable int bookId) {
		service.deleteRecord(bookId);
	}
}