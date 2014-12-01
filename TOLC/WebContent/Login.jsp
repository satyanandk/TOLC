<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
<!-- Bootstrap core CSS -->
<!--Online link to include bootstrap need not include any libraries in eclipse -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<link href="assets/login.css" type="text/css" rel="stylesheet"> 

</head>
<body class="login" >
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class=""><a href="Register.jsp">Register</a></li>

        
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
		<div id="mainFrame">
			<div id="content">
				<div class="row">
  		<div class="span12" style="text-align:center;">
  		<div class="container">
    		<h2>Welcome To Voyage</h2>
  		</div>

<div class="span4" style="background-color:#ffffff;margin-top:10%;border:2px solid;border-radius:25px;margin-left:35%;opacity:0.75">
          <div class="container">
          <div style="color:red;margin-left:4%;margin-top:1%">${exception}</div>
          
          <form action="Login" method="POST">
    	 
	<table style="margin-left:2.5%;margin-top:3%">
		
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
			<td><button class="btn btn-success" type="submit" name="login">Login</button></td>
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