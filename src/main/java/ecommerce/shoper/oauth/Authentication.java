package ecommerce.shoper.oauth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecommerce.shoper.entities.User;

public class Authentication extends HttpServlet{
	
	PrintWriter out = null;
	ObjectMapper objMapper = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		out = resp.getWriter();
		
		String bodyData = req.getReader().readLine();
		User user = objMapper.readValue(bodyData, User.class);
		User newUser = User.DAO.authUser(user);
		
		HttpSession session = req.getSession();
		
		String json = "";
		String outJson = "";
		
		if (newUser != null) {
			newUser.setRole(null);
			json = objMapper.writeValueAsString(newUser);
			
			session.setAttribute("user", newUser);
			
			outJson = "{\"results\":{\"user\":"+json + ",\"error\":"+null+"}}";
		} else {
			outJson = "{\"results\":{\"user\":"+null + ",\"error\":\"Invalid Credentials\"}}";
		}
		
		out.print(outJson);
	
	}
}
