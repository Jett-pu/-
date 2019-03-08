package ques.servlet;
//��ѯ�û��������
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectAnswerServlet
 */
public class SelectAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ѯָ���û��������
		request.setCharacterEncoding("utf-8");// ��ҳ����������ݴ����ʽ
		response.setContentType("text/html;charset=utf-8");// ������ҳ���ı������ʽ
		List<UserOption> list=new ArrayList<UserOption>();
		String account=request.getParameter("account");
		try {
			list=TestConnection.selectAnswer(account);
			request.setAttribute("list", list);
			request.setAttribute("account", account);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ת������
				RequestDispatcher rdis=request.getRequestDispatcher("userAnswer.jsp");
				rdis.forward(request, response);
	}

}
