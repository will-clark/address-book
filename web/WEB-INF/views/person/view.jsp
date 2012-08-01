<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../header.jsp" />

<h2>Person</h2>

<table>
<tr>
	<td>First Name</td>
	<td>${person.firstName}</td>
</tr>
<tr>
	<td>Last Name</td>
	<td>${person.lastName}</td>
</tr>	

</table>

<input type="submit" name="Edit" onclick="javascript:redirect('/person/edit?id=${person.id}')" value="Edit">

<form method="post" action="person/delete">
<input type="hidden" name="id" value="${person.id}">
<input type="submit" value="Delete" onclick="if(confirm('Are you sure you want to delete this?')) return true; else return false;">
</form>

<a href="person/">Back to List</a>

<jsp:include page="../footer.jsp" />