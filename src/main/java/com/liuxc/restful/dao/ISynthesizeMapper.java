package com.liuxc.restful.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISynthesizeMapper {
	List<Map<String, Object>> getUserList();

	List<Map<String, Object>> getDeptList();
}
