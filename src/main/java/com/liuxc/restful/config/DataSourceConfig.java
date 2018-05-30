package com.liuxc.restful.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.io.VFS;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.liuxc.restful.datasource.DataSourceKey;
import com.liuxc.restful.datasource.DynamicDataSource;

@Configuration
public class DataSourceConfig {


	@Primary
	@Bean("master")
	@ConfigurationProperties(prefix = "spring.datasource.druid.master")
	public DataSource getMasterDataSource() {
		
		return DruidDataSourceBuilder.create().build();
	}
	@Bean("slave")
	@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
	public DataSource getSlaveDataSource() {
		
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean("dynamicDataSource")
	public DataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> dataSourceMap = new HashMap<>(2);
		dataSourceMap.put(DataSourceKey.master.name(), getMasterDataSource());
		
		dataSourceMap.put(DataSourceKey.slave.name(), getSlaveDataSource());

		dynamicDataSource.setDefaultTargetDataSource(getMasterDataSource());
		dynamicDataSource.setTargetDataSources(dataSourceMap);
		return dynamicDataSource;
	}

	@Bean
	@ConfigurationProperties(prefix = "mybatis")
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dynamicDataSource());
		VFS.addImplClass(SpringBootVFS.class);//解决打包成jar时无法找到mybatis别名问题
		return sqlSessionFactoryBean;
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(dynamicDataSource());
	}
	
	
}
