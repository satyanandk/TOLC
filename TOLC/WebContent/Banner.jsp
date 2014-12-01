<%@page import="com.asu.tolc.entity.UserEntity"%>
<%UserEntity userEntity = (UserEntity)session.getAttribute("UserEntity");
int noOfposts=0;
int noOfReplies=0;
String userName = "Guest";
if((String)session.getAttribute("UserName") != null)
{
	userName= (String)session.getAttribute("UserName");
}
if(userEntity != null)
{
	noOfposts = userEntity.getNoOfPosts();
	noOfReplies = userEntity.getNoOfReplies();
}
%>

<h2 style="margin-left:2%;">Badges earned
			<% if((noOfposts+noOfReplies)>3)
				{%>
				<image class="icon-star"></image><image class="icon-star"></image></p>
				<%} 
				else if((noOfposts+noOfReplies)<3 && (noOfposts+noOfReplies)>0)
				{%>
				<image class="icon-star"></image>
				<%}%>
</h2>