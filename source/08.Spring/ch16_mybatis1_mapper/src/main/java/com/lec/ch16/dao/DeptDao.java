package com.lec.ch16.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch16.dto.Dept;

@Mapper
public interface DeptDao {
	public List<Dept> deptList();
}
