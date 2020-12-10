package com.xzy.shardingsphere.xa.demo.service;

import com.xzy.shardingsphere.xa.demo.entity.User;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class UserService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    void init() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS t_user");
        jdbcTemplate.execute("CREATE TABLE t_user (user_id BIGINT NOT NULL,  user_name VARCHAR(50), PRIMARY KEY (user_id))");
    }
    
    void cleanup() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS t_user");
    }
    
    @Transactional
    @ShardingTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    public void insert(final int count) {
        for (int i = 0; i < count; i++) {
            User u = new User( i, "init");
            doInsert(u);
        }
    }
    
    @Transactional()
    @ShardingTransactionType(TransactionType.XA)
    public void insertFailed(final int count) {
        for (int i = 0; i < count; i++) {
            User u = new User( i, "init");
            doInsert(u);
        }
        throw new RuntimeException("mock transaction failed");
    }

    
    private void doInsert(User user) {
        Object i = jdbcTemplate.execute("INSERT INTO t_user (user_id, user_name) VALUES (?, ?)", (PreparedStatementCallback<Object>) ps -> {
            ps.setObject(1, user.getUserId());
            ps.setObject(2, user.getUserName());
            return ps.executeUpdate();
        });
    }
    
    int selectAll() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) AS count FROM t_user", Integer.class);
    }
}
