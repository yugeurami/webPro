package com.test.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.test.board.model.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public Board content(int bid);
	public Board getBoard(int bid);
	public int write(Board board, HttpServletRequest request);
	public int reply(Board board, HttpServletRequest request);
	public int modify(Board board, HttpServletRequest request);
	public int delete(int bid);
}
