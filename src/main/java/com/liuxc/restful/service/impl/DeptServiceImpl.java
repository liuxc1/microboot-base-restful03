package com.liuxc.restful.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liuxc.restful.dao.IDeptMapper;
import com.liuxc.restful.datasource.DataSourceAnnotation;
import com.liuxc.restful.datasource.DataSourceKey;
import com.liuxc.restful.domain.Dept;
import com.liuxc.restful.service.IDeptService;

@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptMapper deptDao;

	@Override
	@Transactional(readOnly = true)
	@DataSourceAnnotation(value = DataSourceKey.master)
	public List<Map<String, Object>> getList() {
		return deptDao.getList();
	}

	@Override
	@DataSourceAnnotation(value = DataSourceKey.master)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int insert(Dept dept) {
		int i = deptDao.insert(dept);
		System.out.println(1 / 0);

		return i;
	}

}
