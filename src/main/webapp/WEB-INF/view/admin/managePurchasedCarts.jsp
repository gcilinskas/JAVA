
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Cart List</h1>
                <a href="${contextRoot}/admin/manageCarts" role="btn" class="btn btn-primary">All Carts</a>
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
                        
                            <c:forEach items="${allPurchasedCarts}" var="cart"> 
                                <tr>
                                    <th scope="row">${cart.id}</th>
                                    <td>${cart.users.id}</td>
                                    <td>${cart.users.username}</td>
                                    <td>${cart.dateAdded}</td>
                                    <td>${cart.datePurchased}</td>
                                    <td><a href="${contextRoot}/admin/managePurchasedCarts/manageCartLines/${cart.id}">Cart Lines</a></td>
                                </tr>
                            </c:forEach> 
                       

                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>








