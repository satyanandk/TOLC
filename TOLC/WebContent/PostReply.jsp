<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="java.util.List,java.util.ArrayList,com.asu.tolc.entity.QuestionEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Post a question</title>
<!-- Bootstrap core CSS -->
<!--Online link to include bootstrap need not include any libraries in eclipse -->
<link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">

		<jsp:include page="Banner.jsp"/> 
		<div id="mainFrame">
			<div id="content">
				<div class="row">
					<div class="span3">
						<ul class="nav nav-list">
							<li class="nav-header">Links</li>
							<li><a href="Welcome.jsp">Welcome</a></li>
						</ul>
					</div>
  		<div class="span9">
					<div class="hero-unit">
  		<div class="container">
    		<h1>All questions</h1>
    		
  		</div>
  		
</div>

<div class="span8">
          <div class="container">
          <div style="color:red">${exception}</div>
          
          <form action="PostReplyServlet" method="POST">
    	 
	<table class="table">
		<tr class="thead">
			<td><h4>Posted By</h4></td>
			<td><h4>Question</h4></td>
			<td></td>
		</tr>
		<% List<QuestionEntity> questionEntityList = (ArrayList<QuestionEntity>)session.getAttribute("QuestionEntityList");
			for(QuestionEntity questionEntity:questionEntityList)
			{%>
				<tr>
				<td><%=questionEntity.getUserName() %> </td>
				<td><a href="OpenQuestionServlet1?questionNum=<%=questionEntity.getQuestionNo()%>"><%=questionEntity.getQuestionTitle() %></a></td>
				<td></td>
				</tr>
				
			<%}%>
		
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