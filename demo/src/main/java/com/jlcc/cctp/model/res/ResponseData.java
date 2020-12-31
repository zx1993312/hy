package com.jlcc.cctp.model.res;

import java.util.List;

import lombok.Data;

/**
 * 返回消息体
 * 
 * @author zx
 *
 */
@Data
public class ResponseData {

	public Integer code;// 状态码

	public String message;// 信息

	public List<?> list;// 数据
}
