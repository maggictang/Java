package prototype.deepclones;

import java.io.*;
import java.util.Date;

/**
 * 利用序列化实现深克隆
 * @author Administrator
 *
 */
public class SerializeClone {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Sheep1 s1 = new Sheep1("少莉",new Date());
		System.out.println(s1.getDate());
		//通过序列化把s1对象写到一个字节数组中
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//（2）通过oos把独到的数据传给bos
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		//（1）通过oos读到s1的数据
		oos.writeObject(s1);	
		byte[] bytes = bos.toByteArray();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep1 s2 = (Sheep1) ois.readObject();//通过反序列化得到的s2对象
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