<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
<h1>Add new Product</h1>
<form:form action="processAddProduct" modelAttribute="productModel" method="post">
                <form:input type="text" cssClass="form-control" path="name" placeholder="Enter product name"/>
                Product Expiratation date:

</form:form>
</body>

</html>