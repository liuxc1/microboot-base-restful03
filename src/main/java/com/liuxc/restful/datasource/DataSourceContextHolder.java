package com.liuxc.restful.datasource;

public class DataSourceContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * 设置数据源
	 * 
	 * @param dataSource
	 */
	public static void setDataSource(String dataSource) {
		contextHolder.set(dataSource);
	}

	/**
	 * 获取当前数据源
	 * 
	 * @return
	 */
	public static String getDataSource() {
		return contextHolder.get();
	}

	/**
	 * 清除数据源
	 */
	public static void clearDataSource() {
		contextHolder.remove();
	}
}
