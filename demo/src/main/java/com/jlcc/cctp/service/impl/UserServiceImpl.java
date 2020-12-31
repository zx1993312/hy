package com.jlcc.cctp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlcc.cctp.mapper.UserMapper;
import com.jlcc.cctp.model.entity.UserEntity;
import com.jlcc.cctp.model.vo.UserVo;
import com.jlcc.cctp.service.UserService;
import com.jlcc.cctp.utils.ConvertUtil;

@Service
public class UserServiceImpl implements UserService {

	@SuppressWarnings("rawtypes")
	private static final ConvertUtil CONVER_UTIL = new ConvertUtil();

	@Autowired
	private UserMapper userMapper;

	@Override
	@SuppressWarnings("unchecked")
	public boolean checkUserPassword(String username, String password) {
		UserEntity userEntity = userMapper.selectUserByUsername(username);
		UserEntity entity = new UserEntity();
		entity.setUsername("xx");
		userMapper.insert(entity);
		UserVo userVo = (UserVo) CONVER_UTIL.convert(new UserVo(), userEntity);
		if (userVo != null) {
			if (password.equals(userVo.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
