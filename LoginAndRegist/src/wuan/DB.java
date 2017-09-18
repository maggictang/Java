package wuan;

import java.sql.*;
//数据库有三个字段nickname 昵称，name 用户名，password 密码
public class DB {
	/**
	 * 连接数据库
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
	 * 关闭资源
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
	 * 关闭资源的重载方法
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
	 * 往数据库添加用户
	 * @param nickname 昵称
	 * @param user 用户名
	 * @param password 密码
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
	 * 登录时验证用户是否存在,存在返回true,否则false
	 * 注册时验证用户是否已被注册,已被注册返回true,否则false
	 * @param user 用户名
	 */
	public static boolean existUser(String user) {
		
		Connection c = connectDB();
		Statement s = null;
		//在数据库中查找name为参数user的记录 
		String sql = "select * from user where name = '" + user +"'";
		ResultSet rs = null;
		//标志位：判断用户是否存在,存在true,不存在false
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
	 * 登录时检查用户名和密码是否匹配
	 */
	public static boolean truePsd(String user,String psd) {
		
		Connection c = connectDB();
		Statement s = null;
		ResultSet rs = null;
		//查找用户名为user的密码
		String sql = "select password from user where name = '" + user + "'";
		//标志位，判断用户名和密码是否匹配，正确true，错误false
		boolean truePsd = false;
		
		try {
			s = c.createStatement();
			rs = s.executeQuery(sql);
			//如结果集有结果，进入if，没有进入else
			if(rs.next()) {
				//如果结果集的密码与传入的密码相等返回true，否则返回false
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
