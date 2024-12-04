package com.example.demo.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.BookRepo;

@Service
public class BookService {
	
	List<BookStore> store = new ArrayList<>(Arrays.asList(
			new BookStore(1,"test book 1","abc","xyz",false),
			new BookStore(2,"test book 2","ghi","pyz",false),
			new BookStore(3,"test book 3","def","yz",false)
			));
	
	@Autowired
	private BookRepo repo;
	
	public List<BookStore> getBooks() {
		List<BookStore> lst = repo.getAllBooks();
		return lst;
	}
	
	public BookStore getRecordById(int id) {
		return store.stream()
				.filter(p -> p.getId()==id)
				.findFirst().get();
	}
	
	public void addBook(BookStore book) {
//		store.add(book);
		repo.insert(book);
		System.out.println("Book added!");
	}
	
	public void updateRecord(BookStore book) {
		int idx=0;
		
		for(int i=0;i<store.size();i++) {
			if(store.get(i).getId()==book.getId()) {
				idx=i;
			}
		}
//		store.set(idx, book);
		repo.update(idx, book);
		System.out.println("Updated!");
	}
	public void deleteRecord(int id) {
		int idx=0;
		for(int i=0;i<store.size();i++) {
			if(store.get(i).getId()==id) {
				idx=i;
			}
		}
//		store.remove(idx);
		repo.delete(idx);
		System.out.println("Deleted!");
	}
	
	public BookStore getRecordByName(String name) {
		return store.stream()
				.filter(p->p.getName()==name)
				.findFirst().get();
	}
	
	public BookStore getRecord(String name) {
		return store.stream()
				.filter(p-> p.getAuthorName().equals(name) || p.getPublisherName().equals(name))
				.findFirst().get();
	}
}
