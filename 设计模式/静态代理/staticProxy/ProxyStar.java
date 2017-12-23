package proxy.staticProxy;
/**
 * 经纪人，代理
 * @author Administrator
 *
 */
public class ProxyStar implements Transaction {
	/**
	 * 代理的角色
	 */
	private Star star;
	
	public ProxyStar(Star star) {
		this.star = star;
	}
	
	@Override
	public void conder() {
		// TODO 自动生成的方法存根
		System.out.println("代理人面谈");
	}

	@Override
	public void signContract() {
		// TODO 自动生成的方法存根
		System.out.println("代理人签约");
	}

	@Override
	public void bookTicket() {
		// TODO 自动生成的方法存根
		System.out.println("代理人订票");
	}

	@Override
	public void sing() {
		// TODO 自动生成的方法存根
		star.sing();
	}

	@Override
	public void colletMoney() {
		// TODO 自动生成的方法存根
		System.out.println("代理人收尾款");
	}
	
}
