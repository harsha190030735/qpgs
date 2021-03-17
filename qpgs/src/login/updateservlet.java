package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	// */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
				String uname=request.getParameter("uname");
				String pass=request.getParameter("pass");
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("driver loaded");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");
					PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement("update userlogin set pass='"+pass+"'where username='"+uname+"'");  	
					int count=pstmt.executeUpdate();
					
					// redirect
					
					if(count >0) {
						//successfull creation
						RequestDispatcher rd = request.getRequestDispatcher("updatesuccess.html");
						rd.forward(request, response);
					}else {
						//creation failed
						RequestDispatcher rd = request.getRequestDispatcher("createfail.html");
						rd.forward(request, response);
					}
			}
				catch(Exception e)
				{
				  e.printStackTrace();
				}
	}

}
