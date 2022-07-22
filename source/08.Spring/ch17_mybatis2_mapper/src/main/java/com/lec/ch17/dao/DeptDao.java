package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.model.Dept;

@Mapper
public interface DeptDao {
	public List<Dept> deptList();
}
