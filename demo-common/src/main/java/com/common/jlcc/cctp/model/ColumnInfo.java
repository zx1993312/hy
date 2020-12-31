package com.common.jlcc.cctp.model;

import lombok.Data;

/**
 * 数据库表列信息
 * 
 * @author zx
 */
@Data
public class ColumnInfo {
	/** 字段名称 */
	private String columnName;

	/** 字段类型 */
	private String dataType;

	/** 列描述 */
	private String columnComment;

	/** 列配置 */
	private ColumnConfigInfo configInfo;

	/** Java属性类型 */
	private String attrType;

	/** Java属性名称(第一个字母大写)，如：user_name => UserName */
	private String attrName;
}
