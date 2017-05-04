<%@page import="com.atmecs.TechTonics.util.TalkAttendees"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="java.util.Date" %> --%>
<%@ page import="java.sql.Date" %>
<%@ page import="com.atmecs.TechTonics.pojos.TechTalk" %>
<%@ page import="com.atmecs.TechTonics.pojos.Employee" %>

<!DOCTYPE html>
<html>
<title>Home-TechTonics</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/one.css">
<link rel="stylesheet" href="css/two.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/popupForm.css">
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Open Sans", sans-serif}
</style>
<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Home</a>
 
 
  <a href="logoutServlet" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">Logout</a>
 </div>
</div>



<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card-2 w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">Welcome, ${user.employeeName}</h4>
         
         <hr>
        
		 <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> ${user.employeeEmail}</p>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
            
      
      <br>
      
      <!-- Interests --> 
     <h5 class="w3-center">${talkRequestMessage}</h5>
      <br>
      
      <!-- Alert Box -->
     
    
    <!-- End Left Column -->
    </div>
    <div class="w3-col m2" align="right" style="padding-left: 350px">
      
      <br>
      
      <div class="w3-card-2 w3-round w3-white w3-padding-16 w3-center">
        <button type="button" onclick="location.href='techtalkform.jsp'"  class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> Request for TechTalk </button>
      </div>
      <br>
      
      
      
      
    <!-- End Right Column -->
    </div>
    
    <!-- Middle Column -->
    <div>
   		<table style="width:100%;float:right" class="table table-striped">
		  <thead>
		  <tr align="left">
		  	<th>Date</th>
		    <th>Title</th>
		    <th>Description</th>
		    <th>Presenter</th>
		    <th>Status</th>
		  </tr>
		  </thead>
 
		  <tbody>
		  <c:forEach var="v" items="${techtalks}">
		  
		  <tr align="left">
		  
		  <td>${v.talkDate}</td> 
		  	<td>${v.talkTitle}</td>
		    <td>${v.talkDescription}</td>
		    <td>${v.talkPresenter.employeeName}</td>   
		    <!--  SNIPPET TO CHECK IF ATTENDEE -->
		    <%
		    	HttpSession session1 = request.getSession();
		    	String employeeEmail =((Employee)session1.getAttribute("user")).getEmployeeEmail();
		    	String talkTitle = ((TechTalk)pageContext.getAttribute("v")).getTalkTitle();
		    	boolean isAttendee = TalkAttendees.ifAttendee(talkTitle, employeeEmail);
		    	pageContext.setAttribute("isAttendee", isAttendee);
		    	%>
		    	<c:choose>
		    <c:when test="${not isAttendee}">
		     <td><form action="registerToTechTalk" name="myForm" id="myForm" method="post">
		    <input type="hidden" name="talkTitle" value="${v.talkTitle}"></input>
		    <input type="submit" name="Click to register" value="Click to register"/> 
		    </form></td>
		    </c:when>
		   	 <c:otherwise> 
		   		<td>&#10004 You've already registered</td>
		   	 </c:otherwise> 
		  </c:choose>
		  </tr>
		  
		  </c:forEach>
		  </tbody>
		      </table>
    <!-- End Middle Column -->
    </div>
    
    <!-- Right Column -->
   
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <p class="small text-muted text-center">Copyright &copy; 2017, ATMECS Technologies</p>
</footer>


 
<script>
// Accordion
function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme-d1";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme-d1", "");
    }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>

</body>
</html> 
