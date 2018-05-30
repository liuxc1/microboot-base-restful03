package com.liuxc.restful.service;

import java.util.List;
import java.util.Map;

import com.liuxc.restful.domain.Dept;

public interface IDeptService {
	List<Map<String, Object>> getList();
	
	int insert(Dept dept);
}
