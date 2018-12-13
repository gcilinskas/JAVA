
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Purchased Products</h1>
                <p class="lead"></p>
                <hr class="my-4">
                
                <p class="lead">

                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Cart ID</th>
                            <th scope="col">Product ID</th>
                            <th scope="col">Product Title</th>
                            <th scope="col">Product Unit Price</th>
                            <th scope="col">Quantity</th>

                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allPurchasedProducts}" var="cartLine">      
                        <tr>
                            
                            <th scope="row">${cartLine.id}</th>
                            <td>${cartLine.cart.id}</td>
                            <td>${cartLine.product.id}</td>
                            <td>${cartLine.product.title}</td>
                            <td>${cartLine.product.price}</td>
                            <td>${cartLine.quantity}</td>

                            
                            
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>







