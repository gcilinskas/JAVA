
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
                            <th scope="col">Info</th>
                            <th scope="col">Date Added</th>
                            <th scope="col">Details</th>
                            <th scope="col">Edit Order</th>
                            <th scope="col">Delete Order</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allOrders}" var="order">      
                        <tr>
                            <th scope="row">${order.id}</th>
                            <td>${order.info}</td>
                            <td>${order.dateAdded}</td>
                            <td><a href="${contextRoot}/admin/manageOrders/manageOrderLines/${order.id}">Order Lines</a></td>
                            <td><a href="${contextRoot}/admin/manageOrders/editOrder/${order.id}">Edit Order</a></td>
                            <td><a href="${contextRoot}/admin/deleteOrder/${order.id}">Delete Order</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>







