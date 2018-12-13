
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Order List</h1>
                <p class="lead"></p>
                <hr class="my-4">
                
                <p class="lead">

                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Order ID</th>
                            <th scope="col">Product ID</th>
                            <th scope="col">Product Title</th>
                            <th scope="col">Product Unit Price</th>
                            <th scope="col">Quantity</th>

                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allOrderLines}" var="orderLine">      
                        <tr>
                            
                            <th scope="row">${orderLine.id}</th>
                            <td>${orderLine.order.id}</td>
                            <td>${orderLine.product.id}</td>
                            <td>${orderLine.product.title}</td>
                            <td>${orderLine.product.price}</td>
                            <td>${orderLine.quantity}</td>

                            
                            
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>







