<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up/Login Form</title>
  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/login_signup.css">
</head>
<body>
 <div class="form">
      <div id="tab-content">
    <h1> Request New TechTalk</h1>
      
      
      <div id="login">   
          
          <form action="newTechTalkServlet" method="post">
          
            <div class="field-wrap">
            <label>
              Title<span class="req">*</span>
            </label>
            <input type="text" name="talkTitle" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Description<span class="req">*</span>
            </label>
            <textarea name="talkDescription"></textarea>
          </div>
           <div class="field-wrap">
            <label>
              Date<span class="req">*</span>
            </label>
            <input type="date" name="talkDate" required autocomplete="off">
          </div>
          
          <button onclick="this.document.submit()" class="button button-block">Submit Request</button>
          
          </form>

        </div>
        
       </div>
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/login_signup.js"></script>
</body>
</html>