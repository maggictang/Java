package application;

@SxtTable(value = "tb_student")  //表示这个类和这张表对应
public class SxtStudent {
	@SxtField(colunmName = "id",Type = "int",longth = 10)
	private int id;
	@SxtField(colunmName = "sname",Type = "varchar",longth = 10)
	private String name;
	@SxtField(colunmName = "age",Type = "int",longth = 3)
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
