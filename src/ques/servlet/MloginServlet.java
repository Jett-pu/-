package ques.servlet;

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

public class MloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		��¼
		String account_m = request.getParameter("Mname");
		String psw_m = request.getParameter("Mpassword");
		System.out.printf(account_m+"\t"+psw_m);
		request.setAttribute("account", account_m);
			try {
				//�������ݿ�
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/questionare?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
				Connection con = DriverManager.getConnection(url,"root","root111222");
				
				//	ȷ���û��������Ƿ���ȷ

					String sql1 = "select * from admin where account_m='"+account_m+"'and password_m ='"+psw_m+"'";
					PreparedStatement pre1= con.prepareStatement(sql1);
					ResultSet res1 =pre1.executeQuery();
					if(res1.next()){
						System.out.println("��¼�ɹ�");
						request.setAttribute("password", true);		//������ȷ��ʶ��
						request.setAttribute("account", account_m);
						PrintWriter write = response.getWriter();
						write.write("ok");	
					}
					else{
						//	�������
						request.setAttribute("password", false);	//��������ʶ��
						
						
						
/*						RequestDispatcher dis = request.getRequestDispatcher("#");	//������תҳ��
						dis.forward(request, response);*/
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
