package com.jlcc.cctp.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出excel
 * 
 * @author zx
 *
 */
@Documented
@Inherited // 所标记的类的子类也会拥有这个注解
@Target({ ElementType.FIELD }) // 作用于字段上
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

}
