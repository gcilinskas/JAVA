 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Cart Details</h1>
                <p class="lead"></p>


                <p class="lead">



                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Title</th>
                            <th scope="col">Price</th>
                            <th scope="col">DELETE</th>
                            <th scope="col">Ordering Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allCartLines}" var="cartLine">      
                        <tr>
                            <th scope="row">${cartLine.id}</th>
                            <td>${cartLine.product.title}</td>
                            <td>${cartLine.price}</td>
                            <td><a href="${contextRoot}/cart/delete/${cartLine.id}">DELETE</a></td>
                            <td>${cartLine.quantity}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <hr class="my-4">
                <security:authorize access="isAuthenticated()">
                <c:choose>
                    <c:when test="${fn:length(allCartLines) gt 0}">
                        <a class="btn btn-primary btn-lg" href="${contextRoot}/cart/purchase/" role="button">Purchase All</a>
                    </c:when>
                    <c:otherwise>
                        <h5> Empty Cart </h5>
                    </c:otherwise>
                </c:choose>
                </security:authorize>
                    <security:authorize access="isAnonymous()">
                        <h4 class="d-flex justify-content-center">Login Or Register To Purchase Products</h4>
                        <a class="nav-link d-flex justify-content-center" href="${contextRoot}/login">Login</a>
                        <a class="nav-link d-flex justify-content-center" href="${contextRoot}/users/register">Register</a>
                    </security:authorize>

                </p>
            </div>




        </div>
    </div>
</div>


