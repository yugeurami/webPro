package com.test.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.board.model.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int totCnt();
	public Board getBoard(int bid);
	public int write(Board board);
	public int hitUp(int bid);
	public int stepA(Board board);
	public int reply(Board board);
	public int modify(Board board);
	public int delete(int bid);
}
