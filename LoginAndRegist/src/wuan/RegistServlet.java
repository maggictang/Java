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
		//���ñ��뷽ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//����û��������룬����һ��User����
		String uname = req.getParameter("uname");
		String psd = req.getParameter("psd");	
		User user = new User(uname,psd);
		DB db = new DB();
		//�ж��û����Ƿ��Ѵ���
		if(db.isExistUser(user)) {
			//����,��ʾ�Ѵ���
			db.closeConnection();
			req.setAttribute("msg", "���û��Ѵ���");  
			req.getRequestDispatcher("regist.jsp").forward(req,resp); 
		}
		else {
			//�����ڣ�ȥע��
			//�ж��Ƿ�ɹ������ݿ�ע��
			if(db.registUser(user)) {
				//�ɹ���ת��¼����
				db.closeConnection();
				req.setAttribute("msg", "ע��ɹ������¼");
				req.getRequestDispatcher("login.jsp").forward(req,resp); 
			}
			else {
				db.closeConnection();
				req.setAttribute("msg", "ע��ʧ�ܣ������³���");
				req.getRequestDispatcher("regist.jsp").forward(req,resp); 
				//ע��ʧ��
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		this.doGet(req, resp);
	}
	
}
