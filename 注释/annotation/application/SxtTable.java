package application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ���ע��ָʾĳ������ĳ�ű��Ӧ
 */
//ʹ�÷�Χ����
@Target(value = ElementType.TYPE)
//�������ԣ����й�����
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SxtTable {
	//ֻ��һ����������������ͱ��Ӧ
	String value();

}
