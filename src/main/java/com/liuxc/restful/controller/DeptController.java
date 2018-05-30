package com.liuxc.restful.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuxc.restful.service.IDeptService;

@RestController
@RequestMapping("/dept")
public class DeptController extends AbstractBaseController {
	@Autowired
	private IDeptService deptService;

	@RequestMapping("/getList")
	public List<Map<String, Object>> getList() {
		
		return deptService.getList();
	}
}
