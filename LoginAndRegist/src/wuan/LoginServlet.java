package wuan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3998282882037622755L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码方式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//创建一个User对象
		String uname = req.getParameter("uname");
		String psd = req.getParameter("psd");
		System.out.println(uname+psd);
		User user = new User(uname,psd);
		//与数据库连接
		DB db = new DB();
		//该用户是否已注册
		if(db.isExistUser(user)) {
			//已注册
			if(db.psdIsTrue(user)) {
				//判断用户的密码是否正确
				//正确
				db.closeConnection();
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("welcome.jsp");
			}
			else {
				//错误
				db.closeConnection();
				req.setAttribute("msg", "密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
 		}
		else {
			//没有注册
			db.closeConnection();
			req.setAttribute("msg", "该用户尚未注册");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		this.doGet(req, resp);
	}
	
}
