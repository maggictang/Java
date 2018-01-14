package wuan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = -7294844092044548985L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码方式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获得用户名，密码，创建一个User对象
		String uname = req.getParameter("uname");
		String psd = req.getParameter("psd");	
		User user = new User(uname,psd);
		DB db = new DB();
		//判断用户名是否已存在
		if(db.isExistUser(user)) {
			//存在,提示已存在
			db.closeConnection();
			req.setAttribute("msg", "该用户已存在");  
			req.getRequestDispatcher("regist.jsp").forward(req,resp); 
		}
		else {
			//不存在，去注册
			//判断是否成功在数据库注册
			if(db.registUser(user)) {
				//成功跳转登录界面
				db.closeConnection();
				req.setAttribute("msg", "注册成功，请登录");
				req.getRequestDispatcher("login.jsp").forward(req,resp); 
			}
			else {
				db.closeConnection();
				req.setAttribute("msg", "注册失败，请重新尝试");
				req.getRequestDispatcher("regist.jsp").forward(req,resp); 
				//注册失败
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		this.doGet(req, resp);
	}
	
}
