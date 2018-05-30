package com.liuxc.restful.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liuxc.restful.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractBaseController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/getList")
	public List<Map<String, Object>> getList() {
		
		return userService.getList();
	}
}
