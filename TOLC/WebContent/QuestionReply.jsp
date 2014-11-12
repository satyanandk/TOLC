<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="java.util.List,java.util.ArrayList,com.asu.tolc.entity.QuestionEntity,com.asu.tolc.entity.ReplyEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:fb="http://ogp.me/ns/fb#">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Post a question</title>
<!-- Bootstrap core CSS -->
<!--Online link to include bootstrap need not include any libraries in eclipse -->
<link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</head>
<body>
    	<div id="fb-root"></div>
		<script>(function(d, s, id) {
  			var js, fjs = d.getElementsByTagName(s)[0];
  			if (d.getElementById(id)) return;
  			js = d.createElement(s); js.id = id;
  			js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&appId=386671684813206&version=v2.0";
  			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));</script>
		
<div class="container">

		<jsp:include page="Banner.jsp"/> 
		<div id="mainFrame">
			<div id="content">
				<div class="row">
					<div class="span3">
						<ul class="nav nav-list">
							<li class="nav-header">Links</li>
							<li><a href="Welcome.jsp">Welcome</a></li>
							<script type="text/javascript" id="WolframAlphaScript9c27df3b3526ab15d7666f06025f7305" src="http://www.wolframalpha.com/widget/widget.jsp?id=9c27df3b3526ab15d7666f06025f7305&theme=yellow"></script>
						</ul>
					</div>
  		<div class="span9">
					<div class="hero-unit">
  		<div class="container">
    		<h1>All questions</h1>
    		
  		</div>
  		
</div>

<div class="span8">
<iframe id="QuickTripWidget" allowTransparency="true" src="http://www.quicktrip.com/quicktrip-widget.html?Affiliate=36505e30-1aeb-4af7-886f-1b03527f82b2&Mode=flight&Culture=en-CA" width="728" height="90" scrolling="no" frameBorder="0"></iframe>
          <div class="container">
          <div style="color:red">${exception}</div>
          <div class="fb-like" data-href="" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
          <form action="AddReplyServlet1" method="POST">

<!--end Weatherzone forecast button-->
	<table class="table">
		<tr class="thead">
			<td><h4>Posted By</h4></td>
			<td><h4>Question</h4></td>
			<td></td>
		</tr>
			<% QuestionEntity questionEntity = (QuestionEntity)session.getAttribute("QuestionEntity");%>
				<tr>
				<td><%=questionEntity.getUserName() %> </td>
				<td><%=questionEntity.getQuestion()%></td>
				<td></td>
				</tr>

		</table>
		<br>
		<br>
		<table class="table">
		<tr class="thead">
			<td><h4>Replied By</h4></td>
			<td><h4>Answer</h4></td>
			<td></td>
		</tr>
		<% List<ReplyEntity> replyEntityList = (ArrayList<ReplyEntity>)session.getAttribute("ReplyList");
			if(replyEntityList != null)
			{
				for(ReplyEntity replyEntity:replyEntityList)
				{%>
					<tr>
					<td><%=replyEntity.getRepliedBy() %> </td>
					<td><%=replyEntity.getReply()%></td>
					<td></td>
					</tr>
				
				<%}
			}%>
		</table>
		<table>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Response</td>
			<td><textarea name="reply" rows="10" cols="150"></textarea></td>
			<td></td>
		</tr>
		<tr>
			<td><button class="btn btn-success" type="submit" name="action" value="Subscribe">Subscribe</button></td>
			<td><button class="btn btn-success" type="submit" name="action" value="PostReply">Post</button></td>
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