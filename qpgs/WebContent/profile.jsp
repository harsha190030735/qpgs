<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,javax.servlet.*" %>
 <!DOCTYPE html>
 <html>
 <head>
 <style>
 body
{  
    margin: 0;  
    padding: 0;  
   background-image:url("https://images.pexels.com/photos/2978800/pexels-photo-2978800.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260");
    font-family: 'Arial';  
}  
.login{  
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        background: #262626;  
        border-radius: 15px ; 
        color:white; 
}  
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color:#262626;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 10px 10px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color:#737373;
}

.active {
  background-color:#737373;
}
</style>
 </head>
 <body>
 <div class=login>
 <%
 Cookie[] cookies=request.getCookies();
	if(cookies!=null) {
		for(int i=0;i<cookies.length;i++) {
			Cookie c=cookies[i];%>
			<table border=5>
<tr><td>Field name</td><td>Userdetails</td></tr>
<tr><td><%= c.getName()%></td><td><%= c.getValue()%></td></tr>
</table>
		<% 
		}
	}
%>
</div>
 </body>
 </html>