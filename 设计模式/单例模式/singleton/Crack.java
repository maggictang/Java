package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * 反射和反序列化破解单例模式
 */
public class Crack {

	@SuppressWarnings("all")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		//通过懒汉式获得实例
		Lazy l1 = Lazy.getInstance();
		System.out.println(l1);
		//通过反射破解单利
		@SuppressWarnings("unchecked")
		Class<Lazy> clz = (Class<Lazy>) Class.forName("singleton.Crack");
		Constructor<Lazy> c = clz.getDeclaredConstructor();
		c.setAccessible(true);
		//Lazy l2 = c.newInstance();
		//System.out.println(l1 == l2);
		
		//通过反序列化破解单例
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
		oos.writeObject(l1);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
		Lazy l2 = (Lazy) ois.readObject();
		System.out.println(l2);
	}

}
