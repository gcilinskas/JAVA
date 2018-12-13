
<div class="container">
    <div class="row ">
        <div class="card w-100">

            <div class="jumbotron">
                <h1 class="display-4">Cart List</h1>
        

                <p class="lead"></p>
                <hr class="my-4">

                <p class="lead">

                <table class="table table-hover ">
                    <thead>
                        <tr>
                            <th scope="col">User ID</th>
                            <th scope="col">Username</th>
                            <th scope="col">Is Admin</th>
                            <th scope="col">Cart Lines</th>
                            <th scope="col">Delete User</th>
                        </tr>
                    </thead>
                    <tbody>

                            <c:forEach items="${allUsers}" var="user">

                                <tr>
                                    <th scope="row">${user.id}</th>
                                    <td>${user.username}</td>
                                    <td>${user.isAdmin}</td>
                                    <td><a href="${contextRoot}/admin/manageUserCarts/${user.id}">User Carts</a></td>
                                    <td><a href="${contextRoot}/admin/deleteUser/${user.id}">Delete</a></td>
                                    
                                </tr>
                            </c:forEach> 

         


                    </tbody>
                </table>



                </p>
            </div>




        </div>
    </div>
</div>








