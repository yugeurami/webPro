package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping( value = "method=detail", method = RequestMethod.GET)
	public String bookDetail(int bnum) {
		bookService.getDetailBook(bnum);
		return "book/detail";
	}
}
