package com.jlcc.cctp.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

/**
 * 使用aop向每个Controller中切入日志
 * 
 * @author zx
 *
 */
@Aspect // 该标签把LoggerAspect类声明为一个切面
@Order(1) // 设置切面的优先级：如果有多个切面，可通过设置优先级控制切面的执行顺序（数值越小，优先级越高）
@Component // 该标签把LoggerAspect类放到IOC容器中
@Log4j
public class LoggerAspect {

	@Pointcut("execution(public * com.jlcc.cctp.controller.*Controller.*(..))")
	public void loggerControllerAspect() {
	}

	/**
	 * 前置通知
	 * 
	 * @param joinPoint
	 */
	@Before("loggerControllerAspect()") // 该标签声明次方法是一个前置通知：在目标方法开始之前执行
	public void beforMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info("方法 " + methodName + " 开始执行. 参数<" + args + ">");
	}

	/**
	 * 后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
	 * 
	 * @param joinPoint
	 */
	@After("loggerControllerAspect()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		log.info("方法 " + methodName + " 执行结束.");
	}

	/**
	 * 返回通知（在方法正常结束执行的代码） 返回通知可以访问到方法的返回值！
	 * 
	 * @param joinPoint
	 */
	@AfterReturning(value = "loggerControllerAspect()", returning = "result")
	public void afterReturnMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		log.info("方法 " + methodName + " 执行完成.返回结果<" + result + ">");
	}

	/**
	 * 异常通知（方法发生异常执行的代码） 可以访问到异常对象；且可以指定在出现特定异常时执行的代码
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value = "loggerControllerAspect()", throwing = "ex")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		log.error("方法 " + methodName + " 执行完成.异常信息<" + ex + ">");
	}

	@Around(value = "loggerControllerAspect()")
	public Object aroundMethod(ProceedingJoinPoint point) {

		Object result = null;
		String methodName = point.getSignature().getName();
		try {
			// 前置通知
			log.info("方法 " + methodName + " 开始. 参数<" + Arrays.asList(point.getArgs()) + ">");
			// 执行目标方法
			result = point.proceed();
			// 返回通知
			log.info("方法 " + methodName + " 执行完成. 返回结果<" + result + ">");
		} catch (Throwable e) {
			// 异常通知
			log.error("方法 " + methodName + " 执行完成.异常信息<" + e + ">");
			throw new RuntimeException(e);
		}
		// 后置通知
		log.info("方法 " + methodName + " 执行完成.");
		return result;
	}

}
