package com.jlcc.cctp.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.jlcc.cctp.annotation.validator.CheckDataValidator;

/**
 * 校验数据的注解
 * 
 * @author zx
 *
 */
@Documented
@Inherited // 所标记的类的子类也会拥有这个注解
@Target({ ElementType.FIELD }) // 作用于字段上
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckDataValidator.class) // 表示这个注解是一个验证注解，并且指定了一个实现验证逻辑的验证器
public @interface CheckData {
	public String message() default "";// 错误信息

	public String regex() default "";// 正则表达式，校验邮箱格式

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
