package com.atmecs.TechTonics.userservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.TechTonics.persist.UserSignUp;
import com.atmecs.TechTonics.validations.SignUpValidate;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signupServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employeeEmail = request.getParameter("employeeEmail");
		try{
		if(!SignUpValidate.isEmailRegistered(employeeEmail)){
			String employeePassword = request.getParameter("employeePassword");
			String employeeName = request.getParameter("firstName") +" "+ request.getParameter("lastName");
			UserSignUp.persistUser(employeeEmail, employeeName, employeePassword);
			request.setAttribute("message", "You have successfully registered. You can login now");
			request.getRequestDispatcher("login_signup.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message", "The email you entered is already registered.");
			request.getRequestDispatcher("login_signup.jsp").forward(request, response);
		}
		} catch(Exception e){
			System.out.println("in catch block of do post of signup servlet");
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
