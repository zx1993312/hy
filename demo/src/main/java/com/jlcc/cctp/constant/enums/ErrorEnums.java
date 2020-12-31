package com.jlcc.cctp.constant.enums;

import lombok.Getter;

@Getter
public enum ErrorEnums {
	BAD_REQUEST(400, "存在语法错误"), 
	FORBIDDEN(403, "服务器拒绝访问"), 
	NOT_FOUND(404, "服务器无法找到对应请求资源"),
	INTER_SERVER_ERROR(500, "服务器执行请求时发生错误"), 
	SERVER_UNAVAILABLE(503, "服务器超负载或服务器正在维护");

	ErrorEnums(int code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public int code;

	public String errorMessage;

	public static String getErrorMessage(int code) {
		for (ErrorEnums err : ErrorEnums.values()) {
			if (err.code == code) {
				return err.errorMessage;
			}
		}
		return null;
	}
}
