

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
		//JDBC 불러오기
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
			//넣고자 하는 데이터베이스 값 설정
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
			
			//회원가입 insert
			String sql = "insert into MemberInfo(MNO,MName, MEmail,MBirth) values (?,?,?,?)";
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.setInt(1, mno);
			preparedStatment.setString(2, mname);
			preparedStatment.setString(3,memail);
			preparedStatment.setDate(4, Date.valueOf(mbirth));
			
			preparedStatment.executeUpdate();
			
			//가입 성공할 경우 회원 정보를 세션에 저장
			//세션 객체를 통해 클라이언트와 서버간에 전송할 데이터를 저장하고 공유하는 작업을 수행
			//session "mno"라는 이름으로 데이터를 저장하는 역할을 함
			//request : 현재 클라이언트의 요청에 대한 정보를 제공하는 역할을 함.
			//session 이란? 웹이나 어플리케이션 상태를 유지하고 저장하기 위해서사용
			//getSession() : request에서 현재세션을 가지고 옴
			//setAttribute("mno", mno) : 세션의 데이터를 저장하는 메서드 , mno라는 이름으로 데이터를 저장하고, mno 변수 값이 해당 데이터로 설정되게 함
			// 이렇게 저장된 데이터는 다른 서블릿이나 jsp 페이지에서 접근 가능
			request.getSession().setAttribute("mno", mno);
			request.getSession().setAttribute("mname", mname);
			request.getSession().setAttribute("memail", memail);
			request.getSession().setAttribute("mbirth", mbirth);
			
			
			//성공할 경우 이동할 페이지 설정해주고 다시 전송
			response.sendRedirect("register_success.jsp");
			
		} catch (SQLException e) {
			// 실패할 경우이동할 페이지 설정
			response.sendRedirect("register_error.jsp");
			e.printStackTrace();
		}
	}

}
