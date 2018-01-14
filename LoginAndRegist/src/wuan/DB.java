package wuan;

import java.sql.*;

public class DB {
	
	private String url ="jdbc:mysql://localhost/wuan?useSSL=false";
	private String user = "root";
	private String password = "123456";
	
	private Connection c = null;
	private PreparedStatement ps = null;
	private Statement s = null;
	/**
	 * ����һ�������ݿ����ӵĶ���
	 */
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);		
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	/**
	 * ע���û����ɹ�����true,ʧ�ܷ���false
	 */
	public boolean registUser(User user) {
		String sql = "insert into myuser (uname,psd) values (?,?)";
		try {
			ps = c.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPsd());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * �ж��û����Ƿ��ѱ�ע�ᣬ�Ѵ��ڷ���true,�����ڷ���false
	 */
	public boolean isExistUser(User user) {
		String sql = "select uname from myuser where uname = " + "\"" + user.getUname() + "\"";
		boolean isExistUser = false;
		try {
			s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				isExistUser = true;
				if(rs!=null) {
					rs.close();
				}
			}
			else {
				isExistUser = false;
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return isExistUser;
	}
	/**
	 * �����Ƿ���ȷ
	 */
	public boolean psdIsTrue(User user) {
		String sql = "select psd from myuser where uname = " + "\"" +user.getUname() + "\"";
		try {
			s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				String psd = rs.getString("psd");
				System.out.println(psd);
				if(user.getPsd().equals(psd)) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * �ر������ݿ�����
	 */
  	public void closeConnection() {
		try {
			if(s != null) {
				s.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(c != null) {
				c.close();
			}	
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
