package com.xuziyang.shardingspheredemo.repository;

import com.xuziyang.shardingspheredemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository extends BaseRepository<User, Long> {

}
