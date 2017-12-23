package proxy.staticProxy;
/**
 * 明星本人，真实角色
 * @author Administrator
 *
 */
public class Star implements Transaction {
	private String name;
	
	public Star(String name) {
		this.name = name;
	}
	@Override
	public void conder() {
		// TODO 自动生成的方法存根
		System.out.println("明星本人面谈");
	}

	@Override
	public void signContract() {
		// TODO 自动生成的方法存根
		System.out.println("明星本人签约");
		
	}

	@Override
	public void bookTicket() {
		// TODO 自动生成的方法存根
		System.out.println("明星本人订票");
	}

	@Override
	public void sing() {
		// TODO 自动生成的方法存根
		System.out.println("明星本人"+ this.name + "唱歌");
	}

	@Override
	public void colletMoney() {
		// TODO 自动生成的方法存根
		System.out.println("明星本人收尾款");
	}

}
