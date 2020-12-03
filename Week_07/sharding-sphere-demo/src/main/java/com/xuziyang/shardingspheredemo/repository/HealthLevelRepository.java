package com.xuziyang.shardingspheredemo.repository;

import com.xuziyang.shardingspheredemo.entity.HealthLevel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthLevelRepository extends BaseRepository<HealthLevel, Long> {

}
