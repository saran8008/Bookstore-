package com.mytools.store2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytools.store2.entity.Book;
import com.mytools.store2.repo.Bookrepo;

@Service

public class Bookservice {
	
	
	@Autowired
	private Bookrepo bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
		
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
		
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	
	
	

}
