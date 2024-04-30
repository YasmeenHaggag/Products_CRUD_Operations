<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


</head>
<body>
<h1>Update Product</h1>

<form:form action="processUpdateProduct"  method="post" modelAttribute="productModel">
    <div class="container mt-5">
        ID:
               <input type="text" cssClass="form-control" value="${productModel.id}" path="id" readonly="true"/><br> <br>
        Product name:
                <input type="text" path="name" placeholder="Enter name"><br> <br>
        Product Expiratation date:
                <input type="text" path="Expiratation" placeholder="DD/MM/YY"><br> <br>
        Product Manufacturer:
                <input type="text" path="Manufacturer" placeholder="Manufacturer"><br> <br>
        Product Price:
                <input type="text" path="Price" placeholder="0.00"><br> <br>
<%--        Availability:--%>
<%--               <input type="text" path="Availability" placeholder="0 or 1"><br> <br>--%>
        <input type="submit" class="btn btn-primary" value="save"/>
    </div>
</form:form>
</body>

</html>