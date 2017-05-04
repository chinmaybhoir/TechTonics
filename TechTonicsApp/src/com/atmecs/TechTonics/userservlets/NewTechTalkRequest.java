package com.atmecs.TechTonics.userservlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.TechTonics.persist.NewTalkRequests;
import com.atmecs.TechTonics.pojos.Employee;
import com.atmecs.TechTonics.pojos.TechTalk;
import com.atmecs.TechTonics.util.EmployeeInfo;

/**
 * Servlet implementation class NewTechTalkRequest
 */
@WebServlet("/newTechTalkRequestServlet")
public class NewTechTalkRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTechTalkRequest() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		System.out.println("in newTechTalkReq servlet");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String employeeEmail = request.getParameter("employeeEmail");
		Employee talkPresenter = EmployeeInfo.getEmployeeInfo(employeeEmail);
		String talkTitle = request.getParameter("talkTitle");
		String talkDescription = request.getParameter("talkDescription"); 
		String talkDateString = request.getParameter("talkDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date utilDate = sdf.parse(talkDateString);
		Date talkDate = new Date(utilDate.getTime());
		System.out.println(talkDate);
		TechTalk techTalk = new TechTalk(talkDate, talkTitle, talkDescription, talkPresenter);
		NewTalkRequests.submitNewRequest(techTalk);
		request.setAttribute("talkRequestMessage", "You have successfully requested for new TechTalk. You will be informed about the status soon.");
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
		
		doGet(request, response);
		}
		catch(Exception e){
			System.out.println("Exception at doPost of newTechTalk Servlet");
			e.printStackTrace();
		}
	}

}
