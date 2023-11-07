

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JDBC �ҷ�����
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe?characterEncoding=UTF-8";
		String jdbcUserName="khbank";
		String jdbcPassword="khbank";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
			//�ְ��� �ϴ� �����ͺ��̽� �� ����
			/*
			 	CREATE TABLE MemberInfo (
				    MNO INT PRIMARY KEY,
				    MName VARCHAR(50),
				    MEmail VARCHAR(100),
				    MBirth  DATE
				);
			 */
			
			int mno = Integer.parseInt(request.getParameter("mno"));
			String mname = request.getParameter("mname");
			String memail = request.getParameter("memail");
			String mbirth = request.getParameter("mbirth");
			
			//ȸ������ insert
			String sql = "insert into MemberInfo(MNO,MName, MEmail,MBirth) values (?,?,?,?)";
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setInt(1, mno);
			preparedStatment.setString(2, mname);
			preparedStatment.setString(3,memail);
			preparedStatment.setDate(4, Date.valueOf(mbirth));
			
			preparedStatment.executeUpdate();
			
			//���� ������ ��� ȸ�� ������ ���ǿ� ����
			//���� ��ü�� ���� Ŭ���̾�Ʈ�� �������� ������ �����͸� �����ϰ� �����ϴ� �۾��� ����
			//session "mno"��� �̸����� �����͸� �����ϴ� ������ ��
			//request : ���� Ŭ���̾�Ʈ�� ��û�� ���� ������ �������ϴ� ������ ��.
			//session �̶�? ���̳� ���ø����̼� ���¸� �����ϰ� �����ϱ� ���ؼ����
			//getSession() : request���� ���缼���� ������ ��
			//setAttribute("mno", mno) : ������ �����͸� �����ϴ� �޼��� , mno��� �̸����� �����͸� �����ϰ�, mno ���� ���� �ش� �����ͷ� �����ǰ� ��
			// �̷��� ����� �����ʹ� �ٸ� �������̳� jsp ���������� ���� ����
			request.getSession().setAttribute("mno", mno);
			request.getSession().setAttribute("mname", mname);
			request.getSession().setAttribute("memail", memail);
			request.getSession().setAttribute("mbirth", mbirth);
			
			
			//������ ��� �̵��� ������ �������ְ� �ٽ� ����
			response.sendRedirect("register_success.jsp");
			
		} catch (SQLException e) {
			// ������ ����̵��� ������ ����
			response.sendRedirect("register_error.jsp");
			e.printStackTrace();
		}
	}

}