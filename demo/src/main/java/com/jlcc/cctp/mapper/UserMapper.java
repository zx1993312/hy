package com.jlcc.cctp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jlcc.cctp.model.entity.UserEntity;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

	@Select("select username,password from user where username=#{username}")
	public UserEntity selectUserByUsername(String username);

}
