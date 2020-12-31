package com.common.jlcc.cctp.model;

import java.util.List;

import lombok.Data;

@Data
public class TableInfo {
	/** 表名称 */
	private String tableName;

	/** 表描述 */
	private String tableComment;

	/** 表的主键列信息 */
	private ColumnInfo primaryKey;

	/** 表的列名(不包含主键) */
	private List<ColumnInfo> columns;

	/** 类名(第一个字母大写) */
	private String className;
}
