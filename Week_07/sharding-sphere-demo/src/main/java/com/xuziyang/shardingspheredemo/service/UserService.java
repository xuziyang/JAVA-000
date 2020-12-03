package com.xuziyang.shardingspheredemo.service;

import com.xuziyang.shardingspheredemo.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
	
	public void processUsers() throws SQLException;
	
	public List<User> getUsers() throws SQLException;

}
