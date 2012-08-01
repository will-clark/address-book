<%@ page
    import="java.net.URL"
    import="java.util.Map"
    import="java.util.HashMap"  
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
URL baseUrl;
if (request.getServerPort()==80 || request.getServerPort()==443) {
	baseUrl = new URL(request.getScheme(), request.getServerName(), request.getContextPath());
}
else {
	baseUrl = new URL(request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath());
}
pageContext.setAttribute("baseUrl", baseUrl.toString() + "/");

Object flash = session.getAttribute("flash");
if (flash != null) {
	session.setAttribute("flash", null);
	request.setAttribute("flash", flash);
}

%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<base href="${baseUrl}" />
	<script src="javascript/jquery-1.6.2.min.js" type="text/javascript"></script>
	<script src="javascript/application.js" type="text/javascript"></script>
	<script type="text/javascript">	
		var context_root = "${pageContext.request.contextPath}";
		var base_url = "${baseUrl}";
	</script>
</head>
<body>
<div>${flash}</div>