package com.common.jlcc.cctp.model;

import java.util.List;

import lombok.Data;

@Data
public class TableInfo {
	/** ������ */
	private String tableName;

	/** ������ */
	private String tableComment;

	/** �����������Ϣ */
	private ColumnInfo primaryKey;

	/** �������(����������) */
	private List<ColumnInfo> columns;

	/** ����(��һ����ĸ��д) */
	private String className;
}
