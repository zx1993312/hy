package com.common.jlcc.cctp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gen")
@PropertySource(value = { "classpath:generator.yml" })
public class VelocityConfig {
	/** ���� */
	public static String author;

	/** ���ɰ�·�� */
	public static String packageName;

	/** �Զ�ȥ����ǰ׺��Ĭ����true */
	public static String autoRemovePre;

	/** ��ǰ׺(�������������ǰ׺) */
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
