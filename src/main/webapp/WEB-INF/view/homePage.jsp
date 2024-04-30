<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--        import Bootstrap
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">--%>

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<h1>Products Data</h1>
<div class="tbl-div">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Show Details</th>
            <th scope="col">Add/Update</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>

            <td>
             <c:url var="detailsLink" value="/showDetails">
                 <c:param name="productId" value="${item.id}" />
             </c:url>
            <a class="btn btn-primary" href="<c:out value="${detailsLink}" />">Show Details</a>
            </td>
                <td>
                    <!-- construct an "update" link with product id -->
                    <c:url var="updateLink" value="/updateProduct">
                        <c:param name="productId" value="${item.id}" />
                    </c:url>
                    <a class="btn btn-warning" href="<c:out value="${updateLink}" />">Update</a>
                </td>
                <td>
                    <c:url var="deleteLink" value="/deleteProduct">
                        <c:param name="productId" value="${item.id}" />
                    </c:url>
                    <a class="btn btn-primary" href="<c:out value="${deleteLink}" />">Delete</a>
                </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
    <form:form action="addProduct">
        <input type="submit" class="btn btn-success" value="Add new Product"/>
    </form:form>
</div>
</body>

</html>