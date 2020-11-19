package com.xzy.jdbc;

import java.sql.*;

public class JDBCDemo {
	private static final String URL = "jdbc:mysql://localhost:3306/hello";
	private static final String NAME = "root";
	private static final String PASSWORD = "root";


	private static int insert(User user) {
		Connection conn = getConn();
		int i = 0;
		String sql = "insert into user (id,name) values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	private static int update(User user) {
		Connection conn = getConn();
		int i = 0;
		String sql = "update user set name='" + user.getName() + "' where id='" + user.getId() + "'";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	private static void select() {
		Connection conn = getConn();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id,name from user");
			while (rs.next()) {
				System.out.println(rs.getString("id") + "," + rs.getString("name"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	private static int delete(String id) {
		Connection conn = getConn();
		int i = 0;
		String sql = "delete from user where id='" + id + "'";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}


	private static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		User user = new User("1", "张三");
		insert(user);
		user.setName("李四");
		update(user);
		select();
		delete("1");
	}

}
