package application;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ʹ�÷����ȡע�����Ϣ��ģ�⴦��ע����Ϣ������
 *
 */
@SuppressWarnings(value = { "all" })
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		//��������õ�������������Ϣ������ע��
		Class clz = Class.forName("application.SxtStudent");
		//��ø����������Чע��
		Annotation[] annotations = clz.getAnnotations();
		for(Annotation a : annotations) {
			System.out.println(a);
		}
		//������ָ��ע��
		SxtTable table = (SxtTable) clz.getAnnotation(SxtTable.class);
		System.out.println(table.value());
		//������Ե�ע��
		//�����������
		Field field = clz.getDeclaredField("name");
		SxtField sxtf = field.getAnnotation(SxtField.class);
		System.out.println(sxtf.colunmName() + "--" + sxtf.Type() + "--" + sxtf.longth());
		//���ݻ�õı������ֶ���Ϣ��������Ӧ��SQL��ʹ��JDBCִ��SQL�������ݿ���������صı�
	}

}
