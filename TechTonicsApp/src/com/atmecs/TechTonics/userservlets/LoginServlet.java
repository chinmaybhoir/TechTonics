package com.atmecs.TechTonics.userservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.TechTonics.pojos.Employee;
import com.atmecs.TechTonics.util.EmployeeInfo;
import com.atmecs.TechTonics.util.TechTalksList;
import com.atmecs.TechTonics.validations.LoginValidate;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String adminEmailId = "admin@atmecs.com";
	private static final String adminPassword = "admin123";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			String employeePassword = request.getParameter("employeePassword");
			try{
				if(employeeEmail.equals(adminEmailId)){
					if(employeePassword.equals(adminPassword)){
						request.getRequestDispatcher("adminLoginServlet").forward(request, response);
					}
					else{
						request.setAttribute("message", "Incorrect password! Please try again.");
						request.getRequestDispatcher("login_signup.jsp").forward(request, response);
					}
				}
				else{
			if(LoginValidate.isEmailRegistered(employeeEmail)){
				
				if(LoginValidate.isValidated(employeeEmail, employeePassword)){
					HttpSession session = request.getSession();
					session.setAttribute("user", EmployeeInfo.getEmployeeInfo(employeeEmail));
					session.setAttribute("techtalks", TechTalksList.getTechTalkList());
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "Incorrect password! Please try again.");
					request.getRequestDispatcher("login_signup.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("message", "The email you entered is not registered. Please enter correct email");
				request.getRequestDispatcher("login_signup.jsp").forward(request, response);
				}
			}
			} catch(Exception e){
				System.out.println("Exception at doPost of LoginServlet");
				e.printStackTrace();
			}
		doGet(request, response);
	}

}
