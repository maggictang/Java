package application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 这个注解指示某个类与某张表对应
 */
//使用范围：类
@Target(value = ElementType.TYPE)
//保留策略：运行过程中
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SxtTable {
	//只有一个参数，用来将类和表对应
	String value();

}
