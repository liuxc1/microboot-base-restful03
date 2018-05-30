package com.liuxc.restful.service;

import java.util.List;
import java.util.Map;

import com.liuxc.restful.domain.User;

public interface IUserService {

	List<Map<String, Object>> getList();
	
	int insert(User user);
}
