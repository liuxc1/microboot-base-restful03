package com.liuxc.restful.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.liuxc.restful.domain.User;

@Mapper
public interface IUserMapper {

	List<Map<String, Object>> getList();

	int insert(User user);

}
