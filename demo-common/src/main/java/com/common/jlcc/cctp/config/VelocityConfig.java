package com.common.jlcc.cctp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gen")
@PropertySource(value = { "classpath:generator.yml" })
public class VelocityConfig {
	/** 作者 */
	public static String author;

	/** 生成包路径 */
	public static String packageName;

	/** 自动去除表前缀，默认是true */
	public static String autoRemovePre;

	/** 表前缀(类名不会包含表前缀) */
	public static String tablePrefix;

	public static String getAuthor() {
		return author;
	}

	@Value("${author}")
	public static void setAuthor(String author) {
		VelocityConfig.author = author;
	}

	public static String getPackageName() {
		return packageName;
	}

	@Value("${packageName}")
	public static void setPackageName(String packageName) {
		VelocityConfig.packageName = packageName;
	}

	public static String getAutoRemovePre() {
		return autoRemovePre;
	}

	@Value("${autoRemovePre}")
	public static void setAutoRemovePre(String autoRemovePre) {
		VelocityConfig.autoRemovePre = autoRemovePre;
	}

	public static String getTablePrefix() {
		return tablePrefix;
	}

	@Value("${tablePrefix}")
	public static void setTablePrefix(String tablePrefix) {
		VelocityConfig.tablePrefix = tablePrefix;
	}

}
