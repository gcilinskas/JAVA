
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Purchased Carts</h1>
                <p class="lead"></p>
                <hr class="my-4">
                
                <p class="lead">

                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Date Purchased</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allPurchases}" var="cart">      
                        <tr>
                            <th scope="row">${cart.id}</th>
                            <td>${cart.datePurchased}</td>
                            <td><a href="${contextRoot}/cart/purchases/purchasedProducts/${cart.id}">Purchased Products</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>







