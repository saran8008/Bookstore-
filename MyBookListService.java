package com.mytools.store2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytools.store2.entity.MyBookList;
import com.mytools.store2.repo.MyBookRepo;

@Service
public class MyBookListService {
  @Autowired
  private MyBookRepo mybook;
  
  public void saveMyBooks(MyBookList book) {
	  mybook.save(book);
	  }
  
  public List<MyBookList>getAllMyBooks(){
	  return mybook.findAll();
	  }
  
  public void deleteById(int id) {
	  mybook.deleteById(id);
  }
  
  
}
