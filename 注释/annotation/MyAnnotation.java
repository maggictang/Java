package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
//@Target(value={ElementType.METHOD,ElementType.TYPE}) �ȿ������η���Ҳ����������
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//��������    ������  Ĭ��ֵ�����û��Ĭ��ֵ������ʹ�ø�ע��ʱ������ʽ��������
	String studentName() default "";
	int age() default 0;
	int id() default -1; //-1��ʾ������
	String[] school() default {};
	//��������ֻ��һ��������һ�������Ϊvalue
	
}
