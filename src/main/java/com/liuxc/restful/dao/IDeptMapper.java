package com.liuxc.restful.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.liuxc.restful.domain.Dept;

@Mapper
public interface IDeptMapper {
	
	List<Map<String, Object>> getList();
	
	int insert(Dept dept);
}
