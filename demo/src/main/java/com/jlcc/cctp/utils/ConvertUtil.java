package com.jlcc.cctp.utils;

import java.lang.reflect.Field;
import java.util.Date;

import com.jlcc.cctp.constant.consist.Constants;

import lombok.extern.log4j.Log4j;

/**
 * @param <T>
 * @author zx 转换modal
 */
@Log4j
public class ConvertUtil<T> {

	/**
	 * 将t2值赋给t1
	 *
	 * @param t1 需要转换的实体类（接收数据）
	 * @param t2 被转换的实体类（发送数据）
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public T convert(T t1, T t2) {
		try {
			if (null == t1 || null == t2) {
				return null;
			}

			Class clazz1 = t1.getClass();// 获取t1的class
			Field[] fields1 = clazz1.getDeclaredFields();// 获取字段

			for (Field field1 : fields1) {// 遍历field1
				field1.setAccessible(true);// 私有属性必须设置访问权限

				Class clazz2 = t2.getClass();// 获取t2的class
				Field[] fields2 = clazz2.getDeclaredFields();// 获取字段

				for (Field field2 : fields2) {// 遍历field2
					field2.setAccessible(true);// 私有属性必须设置访问权限
					if (field2.get(t2) != null) {
						if (field1.getName().equals(field2.getName())) {// 校验字段名称是否相等
							if (field2.get(t2).getClass() == Date.class) {
								setFieldValueByFieldName(field1.getName(), t1,
										Constants.TIME_ALL.format(field2.get(t2)));// 设置字段值
							} else {
								setFieldValueByFieldName(field1.getName(), t1, String.valueOf(field2.get(t2)));// 设置字段值
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			return null;
		}

		return t1;
	}

	/**
	 * 根据属性名设置属性值，属性id需自己转换
	 *
	 * @param fieldName
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private void setFieldValueByFieldName(String fieldName, Object object, String value) {
		try {
			// 获取obj类的字节文件对象
			Class c = object.getClass();
			// 获取该类的成员变量
			Field f = c.getDeclaredField(fieldName);
			// 取消语言访问检查
			f.setAccessible(true);
			Class<?> s = c.getDeclaredField(fieldName).getType();
			if (value != null && !value.equals("null")) {
				if (s == int.class) {
					f.set(object, Integer.valueOf(value));
				} else if (s == Date.class) {
					f.set(object, Constants.TIME_ALL.parse(value));
				} else {
					// 给变量赋值
					f.set(object, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
	}

}
