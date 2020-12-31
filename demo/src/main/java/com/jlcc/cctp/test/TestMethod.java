package com.jlcc.cctp.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.jlcc.cctp.constant.enums.ErrorEnums;
import com.jlcc.cctp.utils.DBUtil;

public class TestMethod {

//	@Test
	public void testConn() throws SQLException {
		Connection conn = DBUtil.getConn();
		System.out.println(conn != null);
		DBUtil.close(conn);
	}

	@Test
	public void testCheck() {
		String err = ErrorEnums.getErrorMessage(503);
		System.out.println(err);
	}
}
