package ecommerce.shoper.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentMethod extends HttpServlet{	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	switch (req.getParameter("method")) {
	case "1":
		req.getRequestDispatcher("./PaymentMehotds/MpForm.jsp").forward(req, resp);
		break;
	case "2":
		resp.sendRedirect("/index.jsp");
		break;
	case "3":
		resp.sendRedirect("/index.jsp");
		break;
	default:
		break;
	}	
		
	}
	
	
}
