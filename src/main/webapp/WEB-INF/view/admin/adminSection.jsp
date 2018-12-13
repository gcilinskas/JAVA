<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>


<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Admin Dashboard</h1>
                <p class="lead"></p>
                <hr class="my-4">
                <a href="${contextRoot}/admin/addProduct" type="button" class="btn btn-light btn-lg btn-block">Add New Product</a>
                <a href="${contextRoot}/admin/addOrder" type="button" class="btn btn-light btn-lg btn-block">Add New Order</a>
                <a href="${contextRoot}/admin/addUser" type="button" class="btn btn-light btn-lg btn-block">Add New User</a>
                <a href="${contextRoot}/admin/manageProducts" type="button" class="btn btn-light btn-lg btn-block">Manage All Products</a>
                <a href="${contextRoot}/admin/manageOrders" type="button" class="btn btn-light btn-lg btn-block">Manage All Order Details</a>
                <a href="${contextRoot}/admin/manageCarts" type="button" class="btn btn-light btn-lg btn-block">Manage All Carts</a>
                <a href="${contextRoot}/admin/manageUsers" type="button" class="btn btn-light btn-lg btn-block">Manage All Users</a>

            </div>

        </div>
    </div>
</div>