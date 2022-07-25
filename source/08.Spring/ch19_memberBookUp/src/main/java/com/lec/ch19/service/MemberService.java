package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	public Member idConfirm(String mid);
	public int joinMember(Member member, HttpSession session);
	public String loginCheck(String mid, String mpw, HttpSession session);
	public Member getMemberDto(String mid);
	public int modifyMember(Member member);
}
