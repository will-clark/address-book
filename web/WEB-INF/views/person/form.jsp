<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header.jsp" />

<h2>Person</h2>

<ul id="errors">
<c:forEach var="error" items="${person.validationErrors}">
	<li>${error}</li>
</c:forEach>
</ul>

<form method="post" action="${action}">
<input type="hidden" name="id" value="${person.id}">
<div id="firstName">
	<label>First Name</label>
	<input type="text" name="firstName" value="${person.firstName}"/>
</div>
<div id="lastName">
	<label>Last Name</label>
	<input type="text" name="lastName" value="${person.lastName}"/>
</div>
<input type="submit" value="Save"/>
<input type="button" value="Cancel" onclick="javascript:history.go(-1)"/>
</form>

<jsp:include page="../footer.jsp" />