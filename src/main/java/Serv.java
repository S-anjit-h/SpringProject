

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Serv")
public class Serv extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		Bean b=new Bean();
		b.setName(name);
		b.setPhone(phone);
		b.setEmail(email);
		b.setPass(pass);
		
		try {
			int c=Update.save(b);
			
			if(c>0) {
				out.println("Welcome"+" "+b.getName());
				//response.sendRedirect("Welcome.jsp");
				RequestDispatcher rt=request.getRequestDispatcher("Welcome.jsp");
				rt.include(request, response);
			}
			else {
				out.println("Try again");
				RequestDispatcher rt=request.getRequestDispatcher("Index.jsp");
				rt.forward(request, response);
			}
		}
		catch (Exception e) {
			
		}
		
	}

}
