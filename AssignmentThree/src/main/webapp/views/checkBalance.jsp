<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/User/checkBalance" method="POST" modelAttribute="User">
	UID:<form:input path="uid"/><br>
	<input type="submit" value="Check Balance">
	
</form:form>