package com.jlcc.cctp.model.vo;

import java.util.Date;

import com.jlcc.cctp.annotation.CheckData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo extends BaseVo {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6750859764872310194L;

	public int id;

	@CheckData(message = "不能含有空格", regex = "[a-zA-Z0-9]{1,}")
	public String username;// 用户名

	@CheckData(message = "不能含有空格", regex = "[a-zA-Z0-9]{1,}")
	public String password;// 密码

	@CheckData(message = "邮箱格式不正确", regex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$")
	public String email;// 邮箱

	@CheckData(message = "电话格式不正确", regex = "^((13[0-9])|(17[0-1,6-8])|(15[^4,\\\\D])|(18[0-9]))\\d{8}$")
	public String phone;// 电话
	public Date cteatDate;// 创建日期
	public Date birthday;// 生日
	public Boolean rememberMe = false;// 是否记住开关

}
