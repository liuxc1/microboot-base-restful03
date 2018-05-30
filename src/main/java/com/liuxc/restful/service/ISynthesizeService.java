package com.liuxc.restful.service;

import java.util.List;
import java.util.Map;

import com.liuxc.restful.domain.Dept;
import com.liuxc.restful.domain.User;

public interface ISynthesizeService {
	List<Map<String, Object>> getUserList();

	List<Map<String, Object>> getDeptList();
	
	int insert(Dept dept);
	
	int insertUser(User user);
}
