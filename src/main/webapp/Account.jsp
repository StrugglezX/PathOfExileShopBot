<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" import="java.util.*, poeapi.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PoE Shop Bot</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/AccountStyle.css" />" />
<script type="text/javascript" src="<c:url value="/js/LeagueTabsOpener.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/StashTabsOpener.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/CharacterTabsOpener.js" />"></script>
</head>
 <body>
     <%=(String)session.getAttribute("htmlBody") %>
 </body>
</html>




