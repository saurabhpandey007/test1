<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
    <head>
        <meta charset="utf-8" />
        <title>REAL TIME GRIEVANCE REDRESSAL SYSTEM</title>
        <link href="" rel="stylesheet" type="text/css" />
        <link href="modal.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
       
		 <header>
            
        <!--   <a href="#" class="stuts"> <span>Real Time Grievance Redressal System </span></a>-->
	<%@ include file="header.jsp" %>
		 <div> </div>
        </header>

        <!-- panel with buttons -->
        <div class="main">
            <div class="panel">
            <a href="admin/login" id="login_pop">AdminLogin</a>
                <a href="#login_form" id="login_pop">Student LogIn</a>
                <a href="#join_form" id="join_pop">Coordinator LogIn</a>
				<a href="#about_pop" id="login_pop">About</a>
            </div>

        </div>

        <!-- popup form #1 -->
        <a href="#x" class="overlay" id="login_form"></a>
        <div class="popup">
            <h2>Welcome Student!</h2>
            <p>Please enter your UserName and password here</p>
           <form action="StudentValidation" method="post">
            <div>
                <label for="login">Enter PRN</label>
                <input type="text" id="login"  name="prn"/>
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" />
            </div>
            <input type="submit" value="LogIn" />
		</form> 
		<!-- <form action="StudentValidation">
		<input type="text" id="login"  name="prn"/>
		<input type="password" id="password" name="password" /> -->
            <a class="close" href="#close"></a>
        </div>

        <!-- popup form #2 -->
        <a href="#x" class="overlay" id="join_form"></a>
        <div class="popup">
            <h2>Coordinator LogIn</h2>
            <p>Please enter your Username and Password</p>
            <form action="#">
            <div>
                <label for="username">UserName</label>
                <input type="text" id="username" name="username" />
            </div>
            <div>
                <label for="pass">Password</label>
                <input type="password" id="pass" name="password" />
            </div>
            
            <input type="submit" value="LogIn" />
				</form>
            <a class="close" href="#close"></a>
        </div>
		 <!-- popup form About -->
		 <a href="#x" class="overlay" id="about_pop"></a>
        <div class="popup">
            <p>
			You may receive customer complaints from various sources, such as email, telephone, web etc.
Tracking these complaints enable, you to resolve issues in time, and quickly respond to customers.
Service Desk Lite enables you to record the essential details related to complaint such as the customer contact, the caller details and complaint description.

Recording complaint helps to identify and resolve recurring issues and improve service quality.
			</p>

            <a class="close" href="#close"></a>
        </div>
		 <footer>
           <%@ include file="footer.jsp" %> 
        <!--     <a href="#" class="stuts"><p align="center"> <span><font style="color:#FFFFFF">Copywrite@RTGR Group|Scorpian Group</span></p></a> -->
        </footer>
    </body>
</html>