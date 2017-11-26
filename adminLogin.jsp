<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/styles.css" />
<link rel="stylesheet" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../css/bootstrap-theme.css.map" />
<link rel="stylesheet" href="../css/bootstrap-theme.min.css.map" />
<link rel="stylesheet" href="../css/bootstrap.css.map" />
<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="../css/bootstrap.min.css.map" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body style="background-color:#FFFFCC;">



	<form:form class="form-signin" method="post" modelAttribute="adminModel">
		<table>
			<tr>
				<td><form:label path="adminId">Enter Id</form:label></td>
				<td><form:input path="adminId" class="form-control" placeholder="Password" required/></td>
				<td><form:errors path="adminId" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Enter Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>

 
 <!--  <div class="container">
  <!--      <div class="card card-container" style="background-color: #33CCFF;  border:2px ridge; border-radius: 15px;">
      <!--      <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
       <!--     <img id="profile-img" class="profile-img-card" src="images/cdac.jpg" />
       <!--     <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="vaildate.jsp" method="post">
                <span id="reauth-email" class="reauth-email"> CDAC ADMIN</span>
                <input type="email" id="inputEmail" name="email" class="form-control" placeholder="User Id" required autofocus>
                <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            </form><!-- /form -->
          <!--  <a href="forget_password.jsp" class="forgot-password">
                Forgot your password?
            </a>
        </div><!-- /card-container -->
   <!-- </div><!-- /container -->  
    </body>
</html>