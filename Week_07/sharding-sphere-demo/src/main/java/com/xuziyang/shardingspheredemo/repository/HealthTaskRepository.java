package com.xuziyang.shardingspheredemo.repository;

import com.xuziyang.shardingspheredemo.entity.HealthTask;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthTaskRepository extends BaseRepository<HealthTask, Long> {

}
