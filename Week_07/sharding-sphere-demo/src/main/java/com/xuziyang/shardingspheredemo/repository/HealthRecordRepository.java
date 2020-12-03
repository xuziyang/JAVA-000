package com.xuziyang.shardingspheredemo.repository;

import com.xuziyang.shardingspheredemo.entity.HealthRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HealthRecordRepository extends BaseRepository<HealthRecord, Long> {
    List<HealthRecord> findRemark(long id0, long id1);
}
