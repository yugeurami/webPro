package com.test.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.board.model.Board;
import com.test.board.service.BoardService;
import com.test.board.util.Paging;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST })
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum));
		return "list";
	}
	
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(int bid, Model model) {
		model.addAttribute("boardDto", boardService.content(bid));
		return "content";
	}
	
	@RequestMapping(value = "content", method = RequestMethod.POST)
	public String modifyContent(int bid, Model model) {
		model.addAttribute("boardDto", boardService.getBoard(bid));
		return "content";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeView() {
		return "write";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("writeResult", boardService.write(board, request));
		return "forward:list.do";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("boardDto", boardService.getBoard(bid));
		return "modify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("modifyResult", boardService.modify(board, request));
		return "forward:content.do";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("boardDto", boardService.getBoard(bid));
		return "reply";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(Board board, Model model, HttpServletRequest request) {
		board.setBip(request.getLocalAddr());
		model.addAttribute("replyResult", boardService.reply(board, request));
		return "forward:list.do";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.delete(bid));
		return "forward:list.do";
	}
	
}
