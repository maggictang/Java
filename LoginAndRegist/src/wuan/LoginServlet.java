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
		//����login.jsp���������û���������
		String user = req.getParameter("user");
		String psd = req.getParameter("password");
		
		//�û�������Ϊ��
		if(user =="" || user == null) {
			req.setAttribute("msg", "�û�������Ϊ�գ�");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//���벻��Ϊ��
		else if(psd =="" || psd == null) {
			req.setAttribute("msg", "���벻��Ϊ�գ�");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//����existUser�������ж��Ƿ�������û���
		else if(DB.existUser(user) == false) {
			req.setAttribute("msg", "���û������ڣ�");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//���÷������ж�������û����Ƿ�ƥ��
		else if(DB.truePsd(user, psd) == false) {
			req.setAttribute("msg", "���벻��ȷ��");  
			req.getRequestDispatcher("/login.jsp").forward(req, resp);  
			return;
		}
		//��������û�������Ҳ���û���ƥ��ʱ����½�ɹ�����ת����ӭҳ��
		if (DB.existUser(user) == true && DB.truePsd(user, psd) == true) {
			//�������������ͻ����Ƿ�����session��������򷵻����session,���û���򴴽�һ��
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
