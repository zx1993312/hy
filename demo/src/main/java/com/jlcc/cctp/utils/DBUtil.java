package com.jlcc.cctp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 操作数据库类
 * 
 * @author zx
 *
 */
public class DBUtil {
	
	/**
	 * 获取DB连接
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			// 读取配置文件中的配置
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(is);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			// 注册驱动程序
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param ps
	 * @param conn
	 */
	public static void close(PreparedStatement ps, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param result
	 * @param ps
	 * @param conn
	 */
	public static void close(ResultSet result, PreparedStatement ps, Connection conn) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
