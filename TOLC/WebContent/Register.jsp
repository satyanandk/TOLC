<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome</title>
<!-- Bootstrap core CSS -->
<!--Online link to include bootstrap need not include any libraries in eclipse -->
<link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">

		<h1>
			<a href="#">Welcome</a>
		</h1>
		<div id="mainFrame">
			<div id="content">
				<div class="row">
					<div class="span3">
						<ul class="nav nav-list">
							<li class="nav-header">Links</li>
							<li><a href="Login.jsp">Login</a></li>
						</ul>
					</div>
  		<div class="span9">
					<div class="hero-unit">
  		<div class="container">
    		<h1>Registration</h1>
    		
  		</div>
  		
</div>

<div class="span8">
          <div class="container">
          <div style="color:red">${exception}</div>
          
          <form action="Register" method="POST">
    	 
	<table>
		
		<tr>
			<td>User Name</td>
			<td><input type = "text" name = "userName" ></td>
			<td></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name = "password"></td>
			<td></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type = "text" name = "email" ></td>
			<td></td>
		</tr>
		<tr>
			<td>State</td>
			<td><select name="state">
<option value="Arizona">Arizona</option>
<option value="California">California</option>
<option value="Utah">Utah</option>
<option value="Nevada">Nevada</option>
</select></td>
			<td></td>
		</tr>
		<tr>
		<td><input type="checkbox" name="notifications" value="Y">Receive E-Mail Notifications</td>
		<td></td>
		<td></td>
		</tr>
		<tr>
			<td></td>
			<td><button class="btn btn-success" type="submit" name="Register">Register</button></td>
			<td></td>
		</tr>
	</table>
	</form>
	</div>
	</div>
	</div>
					</div>
					</div>
					</div>
					</div>
					

</body>
</html>