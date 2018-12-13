
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Product List</h1>
                <p class="lead"></p>
                <hr class="my-4">
                
                <p class="lead">

                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Title</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Price</th>
                            <th scope="col">Edit</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allProducts}" var="product">      
                        <tr>
                            <th scope="row">${product.id}</th>
                            <td>${product.title}</td>
                            <td>${product.quantity}</td>
                            <td>${product.price}</td>
                            <td><a href="${contextRoot}/admin/editProduct/${product.id}">EDIT</a></td>
                            <td><a href="${contextRoot}/admin/deleteProduct/${product.id}">DELETE</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>







