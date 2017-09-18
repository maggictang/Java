package wuan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuan.DB;

public class RegistServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		/**
		 * 接收regist.jsp传过来的参数，
		 * @parm user 用户名
		 * @param nickname 昵称
		 * @param password 密码
		 * @param repassword 确认密码
		 */
		String user = req.getParameter("user");
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		
		//用户名不能为空
		if(user =="" || user == null) {
			  req.setAttribute("msg", "用户名不能为空！");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//昵称不能为空
		else if(nickname =="" || nickname == null) {
			  req.setAttribute("msg", "昵称不能为空！");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//密码不能为空
		else if(password =="" || password == null) {
			  req.setAttribute("msg", "密码不能为空！");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//确认密码不能为空
		else if(repassword =="" || repassword == null) {
			  req.setAttribute("msg", "请输确认密码！");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//两次密码要相同
		else if(password.equals(repassword) == false) {
			  req.setAttribute("msg", "两次密码不一致！");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//注册时判断用户名是否已经存在，存在则不让注册
		else if(DB.existUser(user) == true) {
			  req.setAttribute("msg", "该用户名已存在！！");  
			  req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			  return;
		}
		//调用方法注册用户
		else {	
			DB.addUser(nickname,user,password);
			req.setAttribute("msg", "注册成功！恭喜你成为一名煎饼侠！赶快登录看看吧！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp); 		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
}
