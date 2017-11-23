package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
//@Target(value={ElementType.METHOD,ElementType.TYPE}) 既可以修饰方法也可以修饰类
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//参数类型    参数名  默认值（如果没有默认值，则在使用该注解时必须显式传参数）
	String studentName() default "";
	int age() default 0;
	int id() default -1; //-1表示不存在
	String[] school() default {};
	//如果朱姐里只有一个参数，一般参数名为value
	
}
