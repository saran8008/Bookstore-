package com.mytools.store2.controller;




import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mytools.store2.entity.Book;
import com.mytools.store2.entity.MyBookList;
import com.mytools.store2.service.Bookservice;
import com.mytools.store2.service.MyBookListService;



@Controller
public class controller {
	
	
	@Autowired
	private Bookservice service;
	
	@Autowired
	private MyBookListService myBookService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookregister() {
		return "bookregister";
	}
	@GetMapping("/avalable_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("avalable_books","Book",list);
	}
	




	

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		
		service.save(b);
		return "redirect:/avalable_books";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		
		
		return "mybooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id){
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@RequestMapping("/EditBook/{id}")
	public String EditBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "BookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/avalable_books";
	}

}
