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
		//���ñ��뷽ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//����һ��User����
		String uname = req.getParameter("uname");
		String psd = req.getParameter("psd");
		System.out.println(uname+psd);
		User user = new User(uname,psd);
		//�����ݿ�����
		DB db = new DB();
		//���û��Ƿ���ע��
		if(db.isExistUser(user)) {
			//��ע��
			if(db.psdIsTrue(user)) {
				//�ж��û��������Ƿ���ȷ
				//��ȷ
				db.closeConnection();
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("welcome.jsp");
			}
			else {
				//����
				db.closeConnection();
				req.setAttribute("msg", "�������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
 		}
		else {
			//û��ע��
			db.closeConnection();
			req.setAttribute("msg", "���û���δע��");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		this.doGet(req, resp);
	}
	
}
