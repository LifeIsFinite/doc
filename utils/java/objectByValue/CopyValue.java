package javaCode.util;

import java.lang.reflect.Field;

public class CopyValue {

	/**
	 * 将两个相同的引用类型进行值传递（保持地址不变）
	 * 
	 * @param obj1 被赋值对象
	 * @param obj2 赋值对象
	 */
	public void copy(Object obj1, Object obj2) throws Exception {
		// 判断是否是同一类型
		if (!obj1.getClass().getName().equals(obj2.getClass().getName())) {
			throw new Exception("两个对象类型不一致");
		}
		// 获取所有属性
		Field[] fields = obj1.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int i = 0, len = fields.length; i < len; i++) {
			// 获取原来的访问控制权限
			boolean accessFlag = fields[i].isAccessible();
			// 修改访问控制权限
			fields[i].setAccessible(true);
			// 将obj2的属性值赋予obj1
			fields[i].set(obj1, fields[i].get(obj2));
			// 恢复访问控制权限
			fields[i].setAccessible(accessFlag);
		}
	}
}
