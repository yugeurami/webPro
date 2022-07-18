package com.lec.ch11.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto bDto = (BoardDto) map.get("bDto");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		bDto.setBip(request.getRemoteAddr()); 
		BoardDao boardDao = BoardDao.getInstance();
		model.addAttribute("WriteResult", boardDao.write(bDto));
	}

}
