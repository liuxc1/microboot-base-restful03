package com.liuxc.restful.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liuxc.restful.dao.ISynthesizeMapper;
import com.liuxc.restful.datasource.DataSourceAnnotation;
import com.liuxc.restful.datasource.DataSourceKey;
import com.liuxc.restful.domain.Dept;
import com.liuxc.restful.domain.User;
import com.liuxc.restful.service.IDeptService;
import com.liuxc.restful.service.ISynthesizeService;
import com.liuxc.restful.service.IUserService;

@Service
public class SynthesizeServiceImpl implements ISynthesizeService {
	@Autowired
	private ISynthesizeMapper synthesizeMapper;

	@Autowired
	private IDeptService deptService;

	@Autowired
	private IUserService userService;

	@Override
	@Transactional(readOnly = true)
	@DataSourceAnnotation(value = DataSourceKey.slave)
	public List<Map<String, Object>> getUserList() {

		return synthesizeMapper.getUserList();
	}

	@Override
	@Transactional(readOnly = true)
	@DataSourceAnnotation(value = DataSourceKey.master)
	public List<Map<String, Object>> getDeptList() {

		return synthesizeMapper.getDeptList();
	}

	@Override
	public int insert(Dept dept) {
		return deptService.insert(dept);
	}

	@Override
	@DataSourceAnnotation(value = DataSourceKey.slave)
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertUser(User user) {
		int i = userService.insert(user);
		System.err.println(1 / 0);
		return i;
	}

}
