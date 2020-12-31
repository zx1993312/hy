package com.jlcc.cctp.model.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("user")
public class UserEntity extends BaseEntity {

	public int id;

	public String username;// 用户名

	public String password;// 密码

	public String email;// 邮箱

	public String phone;// 电话

	public Date cteatDate;// 创建日期

	public Date birthday;// 生日

	public Integer remFlag;// 是否记住开关
}
