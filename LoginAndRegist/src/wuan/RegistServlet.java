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
		 * ����regist.jsp�������Ĳ�����
		 * @parm user �û���
		 * @param nickname �ǳ�
		 * @param password ����
		 * @param repassword ȷ������
		 */
		String user = req.getParameter("user");
		String nickname = req.getParameter("nickname");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		
		//�û�������Ϊ��
		if(user =="" || user == null) {
			  req.setAttribute("msg", "�û�������Ϊ�գ�");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//�ǳƲ���Ϊ��
		else if(nickname =="" || nickname == null) {
			  req.setAttribute("msg", "�ǳƲ���Ϊ�գ�");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//���벻��Ϊ��
		else if(password =="" || password == null) {
			  req.setAttribute("msg", "���벻��Ϊ�գ�");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//ȷ�����벻��Ϊ��
		else if(repassword =="" || repassword == null) {
			  req.setAttribute("msg", "����ȷ�����룡");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//��������Ҫ��ͬ
		else if(password.equals(repassword) == false) {
			  req.setAttribute("msg", "�������벻һ�£�");  
	          req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			return;
		}
		//ע��ʱ�ж��û����Ƿ��Ѿ����ڣ���������ע��
		else if(DB.existUser(user) == true) {
			  req.setAttribute("msg", "���û����Ѵ��ڣ���");  
			  req.getRequestDispatcher("/regist.jsp").forward(req, resp);  
			  return;
		}
		//���÷���ע���û�
		else {	
			DB.addUser(nickname,user,password);
			req.setAttribute("msg", "ע��ɹ�����ϲ���Ϊһ����������Ͽ��¼�����ɣ�");
			req.getRequestDispatcher("/login.jsp").forward(req, resp); 		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
}
