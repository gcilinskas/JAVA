<%-- 
    Document   : products
    Created on : Dec 4, 2018, 7:30:01 PM
    Author     : Moe
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="col-lg-12">
            <div class="container">
                <div class="row">

                    <c:forEach items="${allProducts}" var="product">

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card">
                                <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                                
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">${product.title}</a>
                                    </h4>
                                    <h5>$ ${product.price}</h5>

                                    <c:choose>
                                        <c:when test="${product.quantity < 1}"><h5> Out of stock! </h5></c:when>
                                        <c:otherwise><h5>${product.quantity} Units left </h5></c:otherwise>
                                    </c:choose>

                                </div>
                                    
                                <div class="card-footer">
                                    <c:choose>
                                        <c:when test="${product.quantity < 1}"></c:when>
                                        <c:otherwise>

                                            <form method="POST" action="${contextRoot}/cart/add/${product.id}">
                                                <input type="number" name="quantityProduct" class="form-control w-25" id="quantityProduct" class="form-control w-25" value="1" max="${product.quantity}" />
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                                <input type="submit" value="ADD TO CART" class="btn btn-light"/>
                                            </form>

                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                    
                            </div>
                        </div>

                    </c:forEach>

                </div>
            </div>
        </div>
        
    </body>
</html>
