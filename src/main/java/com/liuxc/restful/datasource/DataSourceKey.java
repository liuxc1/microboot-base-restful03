package com.liuxc.restful.datasource;

public enum DataSourceKey {

	master("master"), slave("slave");
	
	private DataSourceKey(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
