package com.lec.ch08.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
	// 폼데이터 사용을 위해서는 getter 와 매개변수 없는 생성자가 필요하다
}
