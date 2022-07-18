package com.lec.ch11.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate; // 시간을 뿌려야 할 때 사용
	private Date date; // 시간이 안뿌려짐
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
}
