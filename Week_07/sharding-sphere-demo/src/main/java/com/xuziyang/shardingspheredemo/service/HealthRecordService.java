package com.xuziyang.shardingspheredemo.service;

import com.xuziyang.shardingspheredemo.entity.HealthRecord;

import java.sql.SQLException;
import java.util.List;

public interface HealthRecordService {
    
    void processHealthRecords() throws SQLException;
    
    List<HealthRecord> findRemark();
}
