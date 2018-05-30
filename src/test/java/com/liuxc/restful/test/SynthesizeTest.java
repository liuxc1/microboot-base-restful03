package com.liuxc.restful.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.liuxc.restful.domain.Dept;
import com.liuxc.restful.domain.User;
import com.liuxc.restful.service.ISynthesizeService;

public class SynthesizeTest extends BaseTest {
	@Autowired
	private ISynthesizeService service;

	@Test
	public void getList() throws Exception {
		List<Map<String, Object>> deptList = service.getDeptList();
		System.out.println(deptList.size());
		List<Map<String, Object>> userList = service.getUserList();
		System.out.println(userList.size());
	}
	@Test
	public void insert() throws Exception {
		Dept dept = new Dept();
		dept.setId(2);
		dept.setName("商务部");
		System.err.println(service.insert(dept));
	}
	@Test
	public void insertUser() throws Exception {
		User user = new User();
		user.setId(4);
		user.setName("LLLXC");
		System.err.println(service.insertUser(user));
	}
}
