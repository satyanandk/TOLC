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
							<li><a href="Register.jsp">Register</a></li>
						</ul>
					</div>
  		<div class="span9">
					<div class="hero-unit">
  		<div class="container">
    		<h1>Welcome</h1>
    		<p>Please Login</p>
    		
  		</div>
  		
</div>

<div class="span8">
          <div class="container">
          <div style="color:red">${exception}</div>
          
          <form action="Login" method="POST">
    	 
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
			<td></td>
			<td><button class="btn btn-success" type="submit" name="login">Go</button></td>
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