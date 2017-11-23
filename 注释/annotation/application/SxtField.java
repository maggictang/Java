package application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 这个注解是用来修饰属性的
 */

//使用范围：属性
@Target(value = ElementType.FIELD)
//保留策略：运行过程中
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SxtField {
	String colunmName(); //列名
	String Type(); //数据类型
	int longth(); //长度;

}
