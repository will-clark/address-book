<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header.jsp" />

<h2>People</h2>

<div><a href="person/new">Create</a></div>

<c:choose>
<c:when test="${not empty people}">
<table>
<tr>
	<td>First Name</td>
	<td>Last Name</td>
	<td></td>
</tr>
<c:forEach var="person" items="${people}">
<tr>
	<td>${person.firstName}</td>
	<td>${person.lastName}</td>
	<td><a href="person/view?id=${person.id}">View</a> | <a href="person/edit?id=${person.id}">Edit</a>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise><p>There are no people yet.</p></c:otherwise>
</c:choose>

<jsp:include page="../footer.jsp" />