package com.mytools.store2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mytools.store2.service.MyBookListService;

@Controller

public class MyBookListController {
	
	@Autowired
	private MyBookListService service;
	@RequestMapping("/deleteMyList/{id}")
	public String deleleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return"redirect:/my_books";
		
	}

}
