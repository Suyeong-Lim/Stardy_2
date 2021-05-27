package com.stardy.controller.root;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stardy.entity.Member;
import com.stardy.service.MemberService;
import com.stardy.service.MemberServiceImpl;

@WebServlet("/signup")
public class SignupController extends HttpServlet{

	   static MemberService service = new MemberServiceImpl();
	   
	   @Override
	   protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	      
	      String nickname = request.getParameter("nick");
	      String email = request.getParameter("email");
	      String password = request.getParameter("password");
	      
	      boolean result = service.insertMember(Member.builder().email(email).nickname(nickname).password(password).build());

	      if(result)
	    	  response.sendRedirect("/login.jsp");
	      else
	    	  response.sendRedirect("/signup.jsp");
	   }
	   
	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      
	   }

}
