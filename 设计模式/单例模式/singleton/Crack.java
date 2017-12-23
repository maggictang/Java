package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * ����ͷ����л��ƽⵥ��ģʽ
 */
public class Crack {

	@SuppressWarnings("all")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		//ͨ������ʽ���ʵ��
		Lazy l1 = Lazy.getInstance();
		System.out.println(l1);
		//ͨ�������ƽⵥ��
		@SuppressWarnings("unchecked")
		Class<Lazy> clz = (Class<Lazy>) Class.forName("singleton.Crack");
		Constructor<Lazy> c = clz.getDeclaredConstructor();
		c.setAccessible(true);
		//Lazy l2 = c.newInstance();
		//System.out.println(l1 == l2);
		
		//ͨ�������л��ƽⵥ��
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
		oos.writeObject(l1);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
		Lazy l2 = (Lazy) ois.readObject();
		System.out.println(l2);
	}

}
