package wuan;
/**
 * 用户类
 * @author Administrator
 *
 */
public class User {
	/**
	 * 用户名
	 */
	private String uname;
	/**
	 * 密码
	 */
	private String psd;
	
	/**
	 * 空构造器
	 */
	public User() {
		
	}
	/**
	 * 带参构造器
	 * @param uname 用户名
	 * @param psd 密码
	 */
	public User(String uname,String psd) {
		this.setUname(uname);
		this.setPsd(psd);
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	
	
}
