package com.common.jlcc.cctp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.common.jlcc.cctp.model.ColumnInfo;
import com.common.jlcc.cctp.model.TableInfo;

public interface TableMapper {

	/**
	 * ���ݱ����Ʋ�ѯ��Ϣ
	 * 
	 * @param tableName ������
	 * @return ����Ϣ
	 */
	@Select("select table_name, table_comment, create_time, update_time from information_schema.tables "
			+ "where table_comment <![CDATA[ <> ]]> '' and table_schema = (select database()) and table_name = #{tableName}")
	public TableInfo selectTableByName(String tableName);

	/**
	 * ���ݱ����Ʋ�ѯ����Ϣ
	 * 
	 * @param tableName ������
	 * @return ����Ϣ
	 */
	@Select("select column_name, data_type, column_comment, extra from information_schema.columns "
			+ " where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position")
	public List<ColumnInfo> selectTableColumnsByName(String tableName);
}
