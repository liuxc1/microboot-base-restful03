package com.liuxc.restful.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.liuxc.restful.domain.Dept;
import com.liuxc.restful.domain.User;
import com.liuxc.restful.service.IDeptService;
import com.liuxc.restful.service.IUserService;

public class DataSourceTest extends BaseTest {
	@Autowired
	private IUserService userService;
	@Autowired
	private IDeptService deptService;

	@Resource(name = "master")
	private DataSource master;
	@Resource(name = "slave")
	private DataSource slave;

	@Test
	public void testDataSource() throws Exception {
		System.out.println(master);
		System.out.println(slave);
	}

	@Test
	public void testGetList() throws Exception {
		List<Map<String, Object>> list = userService.getList();

		List<Map<String, Object>> list2 = deptService.getList();
	}

	@Test
	public void insertDept() throws Exception {
		try {
			Dept dept = new Dept();
			dept.setId(4);
			dept.setName("研发部");
			System.err.println(deptService.insert(dept));
			User user = new User();
			user.setId(1);
			user.setName("liuxc1");
			System.err.println(userService.insert(user));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
		}

	}
}
