package proxy.staticProxy;

public class Customer {
	public static void main(String[] args) {
		Star s = new Star("�ܽ���");
		ProxyStar ps = new ProxyStar(s);
		
		ps.conder();
		ps.signContract();
		ps.bookTicket();
		ps.sing();
		ps.colletMoney();
	}
}
