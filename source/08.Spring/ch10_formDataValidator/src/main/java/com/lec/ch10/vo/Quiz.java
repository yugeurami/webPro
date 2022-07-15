package com.lec.ch10.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Quiz {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
}
