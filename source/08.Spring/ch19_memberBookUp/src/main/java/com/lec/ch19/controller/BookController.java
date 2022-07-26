package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping( params = "method=detail", method = {RequestMethod.GET, RequestMethod.POST})
	public String bookDetail(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/detail";
	}
	
	@RequestMapping( params = "method=list", method = RequestMethod.GET)
	public String bookList(String pageNum, String schItem, String schWord, Model model) {
		model.addAttribute("bookList", bookService.bookList(pageNum, schItem, schWord));
		model.addAttribute("paging", new Paging(bookService.totCntBook(schItem, schWord), pageNum));
		return "book/list";
	}
	
	@RequestMapping( params = "method=registerForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String registerForm() {
		return "book/registerForm";
	}
	
	@RequestMapping( params = "method=register", method = RequestMethod.POST)
	public String register(Book book, MultipartHttpServletRequest mRequest, Model model) {
		int result = bookService.registerBook(mRequest, book);
		return "redirect:main.do?registerResult="+result;
	}
	
	@RequestMapping( params = "method=modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/modifyForm";
	}
	
	@RequestMapping( params = "method=modify", method = RequestMethod.POST)
	public String modify(Book book, MultipartHttpServletRequest mRequest, Model model, String pageNum) {
		int result = bookService.modifyBook(mRequest, book);
		return "redirect:book.do?method=detail&bnum="+book.getBnum()+"&modifyResult="+result+"&pageNum="+pageNum;
	}
}
