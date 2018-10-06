<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
	The Customer is confirmed : ${customer.firstName} ${customer.lastName}
	<br/>
	Free Passes: ${customer.freePasses}
</body>
</html>