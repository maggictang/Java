package wuan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuan.DB;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//接收login.jsp传过来的用户名和密码
		String user = req.getParameter("user");
		String psd = req.getParameter("password");
		
		//用户名不能为空
		if(user =="" || user == null) {
			req.setAttribute("msg", "用户名不能为空！");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//密码不能为空
		else if(psd =="" || psd == null) {
			req.setAttribute("msg", "密码不能为空！");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//调用existUser方法：判断是否有这个用户，
		else if(DB.existUser(user) == false) {
			req.setAttribute("msg", "该用户不存在！");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//调用方法：判断密码和用户名是否匹配
		else if(DB.truePsd(user, psd) == false) {
			req.setAttribute("msg", "密码不正确！");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//当有这个用户，密码也和用户名匹配时，登陆成功，跳转到欢迎页面
		if (DB.existUser(user) == true && DB.truePsd(user, psd) == true) {
			//服务器检查这个客户端是否已有session，如果有则返回这个session,如果没有则创建一个
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			if(session.getAttribute("user") != null && session.getAttribute("user").equals(user)) {
			resp.sendRedirect("welcome.jsp");
			}
		}
			
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
