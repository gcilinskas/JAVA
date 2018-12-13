
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Cart List</h1>
                <div class="container">
                    <div class="row mb-2">
                        <div class="col">
                           <a href="${contextRoot}/admin/manageCarts" role="btn" class="btn btn-block btn-light">All Carts</a>
                        </div>
                        <div class="col">
                            <a href="${contextRoot}/admin/managePurchasedCarts" role="btn" class="btn btn-block btn-light">Purchased Carts</a>
                        </div>
                        <div class="col">
                           <a href="${contextRoot}/admin/manageNotPurchasedCarts" role="btn" class="btn btn-block btn-light">Not Purchased Carts</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                           <a href="${contextRoot}/admin/manageNotPurchasedFullCarts" role="btn" class="btn btn-block btn-light">Not Purchased Carts With Cart Lines</a>
                        </div>
                        <div class="col">
                            <a href="${contextRoot}/admin/manageNotPurchasedEmptyCarts" role="btn" class="btn btn-block btn-light">Not Purchased Empty Carts</a>
                        </div>
                        <div class="col">
                           <a href="${contextRoot}/admin/manageAnonymousCarts" role="btn" class="btn btn-block btn-light">Anonymous Carts</a>
                        </div>
                        <div class="col">
                           <a href="${contextRoot}/admin/manageUsersCarts" role="btn" class="btn btn-block btn-light">Users Carts</a>
                        </div>
                    </div>
                </div>
        

                <p class="lead"></p>
                <hr class="my-4">

                <p class="lead">

                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">User ID</th>
                            <th scope="col">Username</th>
                            <th scope="col">Date Added</th>
                            <th scope="col">Date Purchased</th>
                            <th scope="col">Cart Lines</th>
                        </tr>
                    </thead>
                    <tbody>

                    <c:choose>
                        <c:when test="${allCartsB == true}">

                            <c:forEach items="${allCarts}" var="cart">

                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 

                        </c:when>
                        <c:when test="${allPurchasedCartsB == true}">
                            <c:forEach items="${allPurchasedCarts}" var="cart">
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                        </c:when>

                        <c:when test="${allNotPurchasedCartsB == true}">
                            <c:forEach items="${allNotPurchasedCarts}" var="cart"> 
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                        </c:when>

                        <c:when test="${allNotPurchasedFullCartsB == true}">
                            <c:forEach items="${allNotPurchasedFullCarts}" var="cart"> 
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                        </c:when>

                        <c:when test="${allNotPurchasedEmptyCartsB == true}">
                            <c:forEach items="${allNotPurchasedEmptyCarts}" var="cart"> 
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                        </c:when>

                        <c:when test="${allAnonymousCartsB == true}">
                            <c:forEach items="${allAnonymousCarts}" var="cart"> 
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                        </c:when>

                        <c:when test="${allUsersCartsB == true}">
                            <c:forEach items="${allUsersCarts}" var="cart"> 
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/manageCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                        </c:when>

                    </c:choose>


                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>








