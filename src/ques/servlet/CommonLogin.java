package ques.servlet;
//����
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		��¼
		String account = request.getParameter("Lname");
		String psw = request.getParameter("Lpassword");
		System.out.printf(account+"\t"+psw);
		request.setAttribute("account", account);
			try {
				//�������ݿ�
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
				Connection con = DriverManager.getConnection(url,"root","root111222");
				
				//	ȷ���û��������Ƿ���ȷ
				PrintWriter write = response.getWriter();
				response.setCharacterEncoding("utf-8");
					String sql1 = "select * from user where account='"+account+"'and password ='"+psw+"'";
					PreparedStatement pre1= con.prepareStatement(sql1);
					ResultSet res1 =pre1.executeQuery();
					if(res1.next()){
						System.out.println("��¼�ɹ�");
						request.setAttribute("password", true);		//������ȷ��ʶ��
						request.setAttribute("account", account);
						
						write.write("ok");	
					}
					else{
						//	�������
						request.setAttribute("password", false);	//��������ʶ��
						write.write("false");

					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
			

		
	