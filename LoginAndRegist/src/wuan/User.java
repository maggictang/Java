package wuan;
/**
 * �û���
 * @author Administrator
 *
 */
public class User {
	/**
	 * �û���
	 */
	private String uname;
	/**
	 * ����
	 */
	private String psd;
	
	/**
	 * �չ�����
	 */
	public User() {
		
	}
	/**
	 * ���ι�����
	 * @param uname �û���
	 * @param psd ����
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
