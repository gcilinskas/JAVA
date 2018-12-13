<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">${user.username} Cart Details</h1>
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
                    <c:forEach items="${userCartLines}" var="cartLine">      
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

                <c:choose>
                    <c:when test="${fn:length(userCartLines) gt 0}">

                        <form method="POST" action="saveNewOrder">

                            <div class="form-group" style="display: none" >
                                <label for="userId">User ID</label>
                                <input type="number" name="userId" class="form-control w-25" id="userId" class="form-control" value="${userId}" />
                            </div>

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="submit" value="MAKE ORDER"/>

                        </form> 


                    </c:when>
                    <c:otherwise>
                        <h5> Empty Cart </h5>
                    </c:otherwise>
                </c:choose>


                </p>
            </div>



        </div>
      </div>

        <h1>Add Product To "${user.username}" Cart</h1>

        <form method="POST" action="saveNewUserCartLine" class="w-100">

            <div class="form-group" style="display: none" >
                <label for="userId">User ID</label>
                <input type="number" name="userId" class="form-control w-25" id="userId" class="form-control" value="${userId}" />
            </div>

            <div class="form-group" >
                <label for="productId">Product ID</label>
                <input type="number" name="productId" class="form-control w-25" id="productId" class="form-control" />
            </div>

            <div class="form-group" >
                <label for="quantity">Select Quantity</label>
                <input type="number" name="quantity" class="form-control w-25" id="quantity" class="form-control" />
            </div>


            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="submit" value="ADD TO USERS CART" class="btn btn-primary"/>

        </form> 


   
</div>



