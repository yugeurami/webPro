package com.lec.ch19.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Member;

@Mapper
public interface MemberDao {
	public Member idConfirm(String mid);
	public Member getMemberDto(String mid);
	public int joinMember(Member member);
	public int modifyMember(Member member);
}
