package wuan;

import java.sql.*;
//���ݿ��������ֶ�nickname �ǳƣ�name �û�����password ����
public class DB {
	/**
	 * �������ݿ�
	 */	
	public static Connection connectDB() {
		
		String url = "jdbc:mysql://localhost:3306/wuan?characterEncoding=utf8&useSSL=true";
		String user = "root";
		String psd = "123456";
		
		Connection c = null;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(url,user,psd);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace(); 
		}
		
		return c;
	}
	/**
	 * �ر���Դ
	 */
	public static void close(Connection cc,Statement ss) {
		
		Connection c = cc;
		Statement s = ss;
		
		try {
			if(s != null) {
				s.close();
				s = null;
			}
			if(c != null) {
				c.close();
				c = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ر���Դ�����ط���
	 */
public static void close(Connection cc,Statement ss,ResultSet rrs) {
		
		Connection c = cc;
		Statement s = ss;
		ResultSet rs = rrs;
		
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(s != null) {
				s.close();
				s = null;
			}
			if(c != null) {
				c.close();
				c = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ݿ�����û�
	 * @param nickname �ǳ�
	 * @param user �û���
	 * @param password ����
	 */
	public static void addUser(String nickname,String user,String password) {
		
		PreparedStatement ps = null;
		String sql = "insert into user values(?,?,?);";
		Connection c = DB.connectDB();
		
		try {
			c.setAutoCommit(false);
			ps = c.prepareStatement(sql);
			ps.setString(1, nickname);
			ps.setString(2,user);
			ps.setString(3,password);
			ps.executeUpdate();
			c.commit();
			c.setAutoCommit(true);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(c,ps);
		}
	}
	/**
	 * ��¼ʱ��֤�û��Ƿ����,���ڷ���true,����false
	 * ע��ʱ��֤�û��Ƿ��ѱ�ע��,�ѱ�ע�᷵��true,����false
	 * @param user �û���
	 */
	public static boolean existUser(String user) {
		
		Connection c = connectDB();
		Statement s = null;
		//�����ݿ��в���nameΪ����user�ļ�¼ 
		String sql = "select * from user where name = '" + user +"'";
		ResultSet rs = null;
		//��־λ���ж��û��Ƿ����,����true,������false
		boolean exist = false;
		
		try {
			s = c.createStatement();
			rs = s.executeQuery(sql);
			if(rs.next()) {
				exist = true;
			} else {
				exist = false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(c,s,rs);
		}
		
		return exist;
	}
	/**
	 * ��¼ʱ����û����������Ƿ�ƥ��
	 */
	public static boolean truePsd(String user,String psd) {
		
		Connection c = connectDB();
		Statement s = null;
		ResultSet rs = null;
		//�����û���Ϊuser������
		String sql = "select password from user where name = '" + user + "'";
		//��־λ���ж��û����������Ƿ�ƥ�䣬��ȷtrue������false
		boolean truePsd = false;
		
		try {
			s = c.createStatement();
			rs = s.executeQuery(sql);
			//�������н��������if��û�н���else
			if(rs.next()) {
				//���������������봫���������ȷ���true�����򷵻�false
				if(rs.getString("password").equals(psd) == true) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			
			} catch(SQLException e) {
				e.printStackTrace();	
			} finally {
				close(c,s,rs);
			}
		return truePsd;
		
		
	}
}
