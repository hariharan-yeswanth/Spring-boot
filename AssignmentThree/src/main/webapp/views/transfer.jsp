<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/transfer" method="POST" modelAttribute="trans">
    CreditID:<form:input path="credit"/><br>
	DebitID:<form:input path="debit"/><br>
	Amount:<form:input path="amount"/><br>

	<input type="submit" value="Make Transaction">
	
</form:form>