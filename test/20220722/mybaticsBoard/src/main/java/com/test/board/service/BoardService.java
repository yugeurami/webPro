package com.test.board.service;

import java.util.List;

import com.test.board.model.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public Board content(int bid);
	public Board getBoard(int bid);
	public int write(Board board);
	public int reply(Board board);
	public int modify(Board board);
	public int delete(int bid);
}
