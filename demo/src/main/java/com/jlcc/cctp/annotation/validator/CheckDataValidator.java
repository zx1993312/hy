package com.jlcc.cctp.annotation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jlcc.cctp.annotation.CheckData;

/**
 * 实现注解接口，重写isValid方法
 * 
 * @author zx
 *
 */
public class CheckDataValidator implements ConstraintValidator<CheckData, String> {

	private String regex = "";

	/**
	 * 获取正则表达式
	 */
	public void initialize(CheckData data) {
		this.regex = data.regex();
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if (arg0 == null) {
			return false;
		}
		return arg0.matches(regex);
	}

}
