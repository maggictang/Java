package application;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 *
 */
@SuppressWarnings(value = { "all" })
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		//反射可以拿到这个类的所有信息，包括注解
		Class clz = Class.forName("application.SxtStudent");
		//获得该类的所有有效注解
		Annotation[] annotations = clz.getAnnotations();
		for(Annotation a : annotations) {
			System.out.println(a);
		}
		//获得类的指定注解
		SxtTable table = (SxtTable) clz.getAnnotation(SxtTable.class);
		System.out.println(table.value());
		//获得属性的注解
		//获得声明属性
		Field field = clz.getDeclaredField("name");
		SxtField sxtf = field.getAnnotation(SxtField.class);
		System.out.println(sxtf.colunmName() + "--" + sxtf.Type() + "--" + sxtf.longth());
		//根据获得的表名，字段信息，生成响应的SQL，使用JDBC执行SQL，在数据库中生成相关的表
	}

}
