package com.xuziyang.shardingspheredemo.repository;

import com.xuziyang.shardingspheredemo.entity.EncryptUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EncryptUserRepository extends BaseRepository<EncryptUser, Long> {

}
