package com.test.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;
import com.test.board.model.Board;
import com.test.board.util.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int totCnt() {
		return boardDao.totCnt();
	}

	@Override
	public Board content(int bid) {
		boardDao.hitUp(bid);
		return boardDao.getBoard(bid);
	}
	
	@Override
	public Board getBoard(int bid) {
		return boardDao.getBoard(bid);
	}

	@Override
	public int write(Board board) {
		return boardDao.write(board);
	}

	@Override
	public int reply(Board board) {
		boardDao.stepA(board);
		board.setBstep(board.getBstep()+1);
		board.setBindent(board.getBindent()+1);
		return boardDao.reply(board);
	}

	@Override
	public int modify(Board board) {
		return boardDao.modify(board);
	}

	@Override
	public int delete(int bid) {
		return boardDao.delete(bid);
	}

}
