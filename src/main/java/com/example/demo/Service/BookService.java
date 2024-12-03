package com.example.demo.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.*;

@Service
public class BookService {
	
	List<BookStore> store = new ArrayList<>(Arrays.asList(
			new BookStore(1,"test book 1","abc","xyz",false),
			new BookStore(2,"test book 2","ghi","pyz",false),
			new BookStore(3,"test book 3","def","yz",false)
			));
	
	public List<BookStore> getBooks() {
		return store;
	}
	
	public BookStore getRecordById(int id) {
		return store.stream()
				.filter(p -> p.getId()==id)
				.findFirst().get();
	}
	
	public void addBook(BookStore book) {
		store.add(book);
		System.out.println("Book added!");
	}
	
	public void updateRecord(BookStore book) {
		int idx=0;
		
		for(int i=0;i<store.size();i++) {
			if(store.get(i).getId()==book.getId()) {
				idx=i;
			}
		}
		store.set(idx, book);
		System.out.println("Updated!");
	}
	public void deleteRecord(int id) {
		int idx=0;
		for(int i=0;i<store.size();i++) {
			if(store.get(i).getId()==id) {
				idx=i;
			}
		}
		store.remove(idx);
		System.out.println("Deleted!");
	}
}
