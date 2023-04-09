<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/User/menu" method="GET" modelAttribute="Balance">
	<h1>Balance is:-</h1>
   
<h3>UID</h3>${Balance.uid}
<h3>Name</h3>${Balance.name}
<h3>Balance</h3>${Balance.amount}
<br><br>



	<input type="submit" value="menu">
	
</form:form>
