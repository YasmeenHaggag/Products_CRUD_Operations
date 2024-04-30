<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
<h1>Show Product Details</h1>
<form:form action="processUpdateProduct" modelAttribute="productModel" method="post">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="form-group">
                    <h3>Update Product</h3>
                </div>
                <div class="form-group">
                    <label for="name">Id</label>
                    <form:input type="text" cssClass="form-control" value="${productModel.id}" path="id" readonly="true"/>
                    <form:errors path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="name">product name</label>
                    <form:input type="text" cssClass="form-control" path="name"  readonly="true"/>
                    <form:errors path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="expiration">Expiration Date</label>
                    <form:input type="text" cssClass="form-control" path="expiration" readonly="true"/>
                    <form:errors path="expiration" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="manufacturer">Manufacturer</label>
                    <form:input type="text" cssClass="form-control" path="manufacturer"  readonly="true"/>
                    <form:errors path="manufacturer" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input type="text" cssClass="form-control" path="price" readonly="true"/>
                    <form:errors path="price" cssClass="error"/>
                </div>

            </div>
        </div>
    </div>
</form:form>
</body>

</html>