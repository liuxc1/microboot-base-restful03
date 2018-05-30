package com.liuxc.restful.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * 读取资源配置类
 */
public abstract class AbstractBaseController {
	@Autowired
	private MessageSource messageSource;// 有spring自动注入资源对象

	public String get(String key, String... arg) {
		return this.messageSource.getMessage(key, arg, Locale.getDefault());
	}
}
