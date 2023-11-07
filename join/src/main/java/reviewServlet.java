
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewServlet")
public class reviewServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String festivalurl="jdbc:oracle:thin:@localhost:1521:xe";
		String festivaluser="kiga";
		String festivalpassword="kiga1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(festivalurl, festivaluser, festivalpassword);
			
			
			int r_id=1;
			String review=request.getParameter("review");
			String review_title=request.getParameter("review_title");
		
			
			String sql="insert into review(r_id,review,review_title) values(?,?,?)";
			
			PreparedStatement ps =con.prepareStatement(sql);
			
		
			ps.setInt(1, r_id);
			ps.setString(2, review);
			ps.setString(3, review_title);

			ps.executeUpdate();
			
			
	
			request.getSession().setAttribute("r_id",r_id);
			request.getSession().setAttribute("review",review);
			request.getSession().setAttribute("review_title",review_title);
			
			
			response.sendRedirect("reviewsucess.jsp");
			
			
			
		} catch (SQLException e) {
			response.sendRedirect("reviewerror.jsp");
			e.printStackTrace();
		}
		
		
		
	}

}