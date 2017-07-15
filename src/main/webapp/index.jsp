<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" import="java.util.*, poeapi.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PoE Shop Bot</title>
<style type="text/css"> 
	body {background-color:gray; font-size=10pt;}
	H1 {font-size:20pt;}
</style>
</head>
<body>
	<h1>PoE Bot Shop</h1>
	<hr/>
	<p/>
    <% 
    //String accountName = (String)session.getValue("accountName");
    //	if(accountName != null){
    //		response.sendRedirect("/PoeBotShop/Account.jsp");
    //	}
	%>
      <form name="loginForm" action="login" method="POST">
          <table>
             <tr>
              <td>
                  Account Name:
              </td>
              <td>
              <input type="text" name="accountName">
              </td>
             </tr>
             <tr>
             <td>
                  POESESSID
              </td>
              <td>
              <input type="text" name="POESESSID">
              </td>
              </tr>
              <tr>
              <td>
              </td>
              <td>
              <input type="submit" value="Login">
              <input type="hidden" name="do_this" value="login">
              </td>
              <td>
          </table>
      </form>
   </body>
</html>




