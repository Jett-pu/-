package ques.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitServlrt
 */
public class SubmitServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		request.setCharacterEncoding("utf-8");// ��ҳ����������ݴ����ʽ
		response.setContentType("text/html;charset=utf-8");// ������ҳ���ı������ʽ
		String account=request.getParameter("account");
		try {
			String sql="select * from question_id ";
			ResultSet rs=TestConnection.selectDB(sql);
			while(rs.next()) {
				String id=rs.getString(1);	
				String option=request.getParameter(id);//���id��rs.getString(1);
				TestConnection.saveAnswer(account, id, option);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("http://localhost:8080/Questionare/Login.html");
	}

}
