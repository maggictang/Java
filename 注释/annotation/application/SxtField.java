package application;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ���ע���������������Ե�
 */

//ʹ�÷�Χ������
@Target(value = ElementType.FIELD)
//�������ԣ����й�����
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SxtField {
	String colunmName(); //����
	String Type(); //��������
	int longth(); //����;

}
