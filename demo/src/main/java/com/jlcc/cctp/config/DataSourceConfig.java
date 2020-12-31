package com.jlcc.cctp.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * 多数据源配置
 * 
 * @author zx
 *
 */
@Configuration
public class DataSourceConfig {

	@Primary
	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db1")
	public DataSource dataSourceCmuser() {
		return DruidDataSourceBuilder.create().build();
	}

//	@Primary
//	@Qualifier("dataSource1")
	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.datasource.druid.db2")
	public DataSource dataSourceIrms() {
		return DruidDataSourceBuilder.create().build();
	}
}