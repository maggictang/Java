package prototype.deepclones;

import java.io.*;
import java.util.Date;

/**
 * �������л�ʵ�����¡
 * @author Administrator
 *
 */
public class SerializeClone {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Sheep1 s1 = new Sheep1("����",new Date());
		System.out.println(s1.getDate());
		//ͨ�����л���s1����д��һ���ֽ�������
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//��2��ͨ��oos�Ѷ��������ݴ���bos
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		//��1��ͨ��oos����s1������
		oos.writeObject(s1);	
		byte[] bytes = bos.toByteArray();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep1 s2 = (Sheep1) ois.readObject();//ͨ�������л��õ���s2����
		s2.setDate(new Date(145644563412142L));
		System.out.println(s1.getDate());
		System.out.println(s2.getDate());
	}
}

@SuppressWarnings("serial")
class Sheep1 implements Cloneable,Serializable{ 
	private Date date;
	private String name;
	
	public Sheep1(String name,Date date) {
		this.setDate(date);
		this.setName(name);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}