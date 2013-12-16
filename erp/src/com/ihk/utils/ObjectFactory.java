package com.ihk.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.ihk.utils.log.LoggerUtils;

/**
 * 对象创建工厂
 * @author YZJ
 * 
 */
public class ObjectFactory {

	private static final Map<String, Class<?>> primitiveClazz; // 基本类型的class

	private static final String INTEGER = "java.lang.Integer";
	private static final String BYTE = "java.lang.Byte";
	private static final String CHARACTOR = "java.lang.Charactor";
	private static final String SHORT = "java.lang.Short";
	private static final String LONG = "java.lang.Long";
	private static final String FLOAT = "java.lang.Float";
	private static final String DOUBLE = "java.lang.Double";
	private static final String BOOLEAN = "java.lang.Boolean";

	static {
		primitiveClazz = new HashMap<String, Class<?>>();
		primitiveClazz.put(INTEGER, int.class);
		primitiveClazz.put(BYTE, byte.class);
		primitiveClazz.put(CHARACTOR, char.class);
		primitiveClazz.put(SHORT, short.class);
		primitiveClazz.put(LONG, long.class);
		primitiveClazz.put(FLOAT, float.class);
		primitiveClazz.put(DOUBLE, double.class);
		primitiveClazz.put(BOOLEAN, boolean.class);
	}

	/**
	 * 无参构造的实例化,参数形式:类型.class , 取实例后转为对象的类型
	 * 
	 * @param clazz
	 * @return
	 */
	public static Object getInstance(Class<?> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			LoggerUtils
					.error("1.类型为抽象类或接口，不能创建对象  2.类型的构造函数不为无参构造,请使用getInstance(Class<?> clazz, Object... objs)", clazz);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			LoggerUtils.error("该类型的构造方法访问不到，不能使用此方法创建对象", clazz);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 有参构造的实例化
	 * 
	 * @param clazz
	 *            (创建对象的类，类.class)
	 * @param objs
	 *            (构造函数的参数列表)
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Object getInstance(Class<?> clazz, Object... objs) {
		try {
			Class<?>[] c = new Class<?>[objs.length];
			for (int i = 0; i < objs.length; i++) {
				if (primitiveClazz.get(objs[i].getClass().getName()) == null) {
					// 判断参数是否为基本数据类型，如果不是，直接获取对应class放入class数组
					// 如果是，转为对应基本类型后再放入class数组(因为传入为数字的时候，获取的类型为对应的包装类，所以要转为对应基本类型)
					c[i] = objs[i].getClass();
				} else {
					c[i] = primitiveClazz.get(objs[i].getClass().getName());
				}
			}
			try {
				return clazz.getConstructor(c).newInstance(objs);
			} catch (NoSuchMethodException e) {
				LoggerUtils.error("没有对应的构造方法", clazz);
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			LoggerUtils
					.error("类型为抽象类或接口，不能创建对象", clazz);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			LoggerUtils.error("该类型的构造方法访问不到，不能使用此方法创建对象", clazz);
			e.printStackTrace();
		}
		return null;
	}

}
